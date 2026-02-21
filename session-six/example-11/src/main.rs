fn main() {
    // ----- ARRAYS -----
    // Elements in an array must be of the same type and have a fixed size

    let arr_1 = [1, 2, 3, 4];

    // Get value by index starting at 0

    println!("1st : {}", arr_1[0]);

    // Get array length

    println!("Length : {}", arr_1.len());

    // ----- LOOP -----
    // Create an infinite loop that ends when break is called

    let arr_2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
    let mut loop_idx = 0;
    loop {
        if arr_2[loop_idx] % 2 == 0 {
            loop_idx += 1;
            continue; // Goes to beginning of loop
        }

        if arr_2[loop_idx] == 9 {
            break; // Breaks out of loop
        }

        println!("Val : {}", arr_2[loop_idx]);
        loop_idx += 1;
    }

    // ----- WHILE LOOP -----
    // Looping based on a condition

    loop_idx = 0;
    while loop_idx < arr_2.len() {
        println!("Arr : {}", arr_2[loop_idx]);
        loop_idx += 1;
    }
}
