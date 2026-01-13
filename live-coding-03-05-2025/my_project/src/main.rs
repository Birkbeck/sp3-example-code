fn main() {
    // let mut x: i32 = 4_200_000;
    // println!("x = {}", x);
    // x = 56;
    // println!("x = {}", x);

    // let pair = ('a', 17);
    // println!("First pair = {}", pair.0);
    // println!("Second pair = {}", pair.1);

    // let pair: (char, i32) = ('a', 17);
    // println!("First pair = {}", pair.0);
    // println!("Second pair = {}", pair.1);

    // let (_,b) = ('a', 17);
    //println!("First pair = {}", a);
    // println!("Second pair = {}", b);

    // let x = vec![1, 2, 3, 4, 5, 6, 7, 8];
    // println!("Vec = {:?}", x);
    // let sum = x.iter().map(|x| x + 3).sum::<i32>(); //fold(0, |x, y| x + y);
    // println!("sum = {}", sum);

    println!("my_func call = {}", my_func());

    // let x = "out";
    // {
    //     // this is a different `x`
    //     let x = "in";
    //     println!("{}", x);
    // }
    // println!("{}", x);

    // println!("result = {}", "man utd".len());
    // println!("result = {}", str::len("man utd"));

    #[derive(Debug)]
    struct Rec2 {
        x: f64,
        y: f64,
    }

    let r1 = Rec2 { x: 1.0, y: 3.0 };
    println!("r1 = {:?}", r1);
    
    let Rec2 {x, y} = r1;
    println!("x = {} y = {}", x, y);
}

fn my_func() -> i32 {
    4
}

