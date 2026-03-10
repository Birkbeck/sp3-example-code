fn main() {
    // let arr_1 = [1,2,3,4];
    // println!("1st element : {}", arr_1[0]);
    // println!("Length : {} ", arr_1.len());

    let mut s1 = String::from("Hello");
    change_string(&mut s1);
    println!("String is {}", s1);
}

fn change_string(s: &mut String){
    s.push_str(", Rust!");
}

// i8 u8
// i16 u16
// i32 u32
// i64 u64
// i128 u128
// isize usize
