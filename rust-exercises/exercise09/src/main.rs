// Implementing Iterator only requires next().
// All other adaptor methods (map, filter, fold, zip, enumerate, …) are provided for free by default trait methods,
// which is Rust's zero-cost abstraction in action.

#![allow(warnings)]
#[derive(Debug)]
struct Matrix<T> {
    data: Vec<Vec<T>>,
    rows: usize,
    cols: usize,
}

impl<T: Clone + Default> Matrix<T> {
    fn new(rows: usize, cols: usize) -> Self {
        Matrix {
            data: vec![vec![T::default(); cols]; rows],
            rows,
            cols,
        }
    }
    fn set(&mut self, r: usize, c: usize, val: T) {
        self.data[r][c] = val;
    }
    fn get(&self, r: usize, c: usize) -> &T {
        &self.data[r][c]
    }
}

// ── Row-major iterator ───────────────────────────────────────────────
struct RowMajorIter<'a, T> {
    matrix: &'a Matrix<T>,
    row: usize,
    col: usize,
}

impl<'a, T> Iterator for RowMajorIter<'a, T> {
    type Item = &'a T;
    fn next(&mut self) -> Option<Self::Item> {
        if self.row >= self.matrix.rows {
            return None;
        }
        let item = &self.matrix.data[self.row][self.col];
        self.col += 1;
        if self.col >= self.matrix.cols {
            self.col = 0;
            self.row += 1;
        }
        Some(item)
    }
}

// ── Column-major iterator ────────────────────────────────────────────
struct ColMajorIter<'a, T> {
    matrix: &'a Matrix<T>,
    row: usize,
    col: usize,
}

impl<'a, T> Iterator for ColMajorIter<'a, T> {
    type Item = &'a T;
    fn next(&mut self) -> Option<Self::Item> {
        if self.col >= self.matrix.cols {
            return None;
        }
        let item = &self.matrix.data[self.row][self.col];
        self.row += 1;
        if self.row >= self.matrix.rows {
            self.row = 0;
            self.col += 1;
        }
        Some(item)
    }
}

// ── IntoIterator (enables `for x in &matrix`) ────────────────────────
impl<'a, T> IntoIterator for &'a Matrix<T> {
    type Item = &'a T;
    type IntoIter = RowMajorIter<'a, T>;
    fn into_iter(self) -> Self::IntoIter {
        RowMajorIter {
            matrix: self,
            row: 0,
            col: 0,
        }
    }
}

impl<T: Clone + Default> Matrix<T> {
    fn row_major(&self) -> RowMajorIter<T> {
        RowMajorIter {
            matrix: self,
            row: 0,
            col: 0,
        }
    }
    fn col_major(&self) -> ColMajorIter<T> {
        ColMajorIter {
            matrix: self,
            row: 0,
            col: 0,
        }
    }

    // Diagonal via combinators — no manual struct needed
    fn diagonal(&self) -> impl Iterator<Item = &T> {
        let n = self.rows.min(self.cols);
        (0..n).map(move |i| &self.data[i][i])
    }
}

fn main() {
    let mut m: Matrix<i32> = Matrix::new(3, 3);
    let vals = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
    for r in 0..3 {
        for c in 0..3 {
            m.set(r, c, vals[r][c]);
        }
    }

    print!("Row-major : ");
    for v in &m {
        print!("{} ", v);
    } // 1 2 3 4 5 6 7 8 9
    println!();

    print!("Col-major : ");
    for v in m.col_major() {
        print!("{} ", v);
    } // 1 4 7 2 5 8 3 6 9
    println!();

    print!("Diagonal  : ");
    for v in m.diagonal() {
        print!("{} ", v);
    } // 1 5 9
    println!();

    // Free adaptor methods
    let sum: i32 = m.row_major().sum();
    println!("Sum: {}", sum); // 45
}
