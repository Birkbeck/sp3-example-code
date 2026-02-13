// Lifetimes describe how long references stay valid.
// The 'a annotation on TextAnalysis ties the struct to the string it borrows — the struct cannot outlive that string.

struct TextAnalysis<'a> {
    source: &'a str,
    words: Vec<&'a str>, // each word is a slice of source
}

impl<'a> TextAnalysis<'a> {
    fn new(source: &'a str) -> Self {
        let words = source.split_whitespace().collect();
        TextAnalysis { source, words }
    }

    fn longest_word(&self) -> &str {
        // The returned reference lives as long as self.words,
        // which lives as long as 'a.  Lifetime elision works here
        // because the only possible source is self.
        self.words
            .iter()
            .max_by_key(|w| w.len())
            .copied()
            .unwrap_or("")
    }

    fn word_count(&self) -> usize {
        self.words.len()
    }
}

// Both inputs share the same lifetime 'a.
// The output must be one of the inputs, so it also lives 'a.
fn first_longer_than<'a>(a: &'a str, b: &'a str, threshold: usize) -> &'a str {
    if a.len() > threshold { a } else { b }
}

fn main() {
    let text = String::from("the quick brown fox jumps over the lazy dog");
    let analysis = TextAnalysis::new(&text);
    println!("Longest word : {}", analysis.longest_word()); // jumps
    println!("Word count   : {}", analysis.word_count()); // 9

    let result = first_longer_than("short", "a much longer string", 4);
    println!("First longer : {}", result);

    // ---- Compile error demo (leave commented out) ----
    // let dangling: &str;
    // {
    //     let local = String::from("dropped");
    //     let a = TextAnalysis::new(&local);  // 'a tied to local
    //     dangling = a.longest_word();        // ERROR: local dropped here
    // }
    // println!("{}", dangling); // use after free — compiler rejects this
}

// Key Takeaways
//
// Lifetime annotations never change how long data lives — they only describe relationships.
// The compiler uses them to verify that no reference outlives its data.
// When a function returns a reference, its lifetime must be tied to at least one input lifetime (or 'static).
//
