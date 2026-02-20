// unsafe only suppresses four specific compiler checks.
// All other safety rules (lifetimes, borrows, type checking) still apply inside unsafe blocks.
// Always document SAFETY invariants in a comment above each unsafe block.

// ── Simulated C statistics library (normally compiled as a .so) ───────
// For the exercise we simulate in Rust; in production you'd link a real C lib.

use std::sync::Mutex;
static SAMPLES: Mutex<Vec<f64>> = Mutex::new(Vec::new());

// Extern C ABI simulation (replace with real FFI declarations)
unsafe extern "C" fn add_sample_c(value: f64) {
    SAMPLES.lock().unwrap().push(value);
}
unsafe extern "C" fn compute_mean_c() -> f64 {
    let s = SAMPLES.lock().unwrap();
    if s.is_empty() {
        return 0.0;
    }
    s.iter().sum::<f64>() / s.len() as f64
}
unsafe extern "C" fn reset_samples_c() {
    SAMPLES.lock().unwrap().clear();
}

// ── Safe wrapper ──────────────────────────────────────────────────────
struct Stats;

impl Stats {
    pub fn new() -> Self {
        // SAFETY: reset_samples_c only modifies a Mutex-protected Vec.
        unsafe {
            reset_samples_c();
        }
        Stats
    }
    pub fn add(&self, value: f64) {
        // SAFETY: add_sample_c only pushes to a Mutex-protected Vec.
        unsafe {
            add_sample_c(value);
        }
    }
    pub fn mean(&self) -> f64 {
        // SAFETY: compute_mean_c reads a Mutex-protected Vec.
        unsafe { compute_mean_c() }
    }
}

// ── Raw pointer arithmetic ────────────────────────────────────────────
/// Split a slice at `mid` without bounds checking.
/// # Safety
/// Caller must ensure `mid <= slice.len()`.
unsafe fn split_at_unchecked<T>(slice: &[T], mid: usize) -> (&[T], &[T]) {
    unsafe {
        let ptr = slice.as_ptr();
        let len = slice.len();
        // SAFETY: caller guarantees mid <= len; ptr arithmetic stays in-bounds.
        (
            std::slice::from_raw_parts(ptr, mid),
            std::slice::from_raw_parts(ptr.add(mid), len - mid),
        )
    }
}

fn main() {
    // Safe Stats API
    let stats = Stats::new();
    for v in [10.0, 20.0, 30.0, 40.0] {
        stats.add(v);
    }
    println!("Mean: {}", stats.mean()); // 25.0

    // Raw pointer split
    let data = [1, 2, 3, 4, 5];
    let (left, right) = unsafe { split_at_unchecked(&data, 3) };
    println!("left: {:?}, right: {:?}", left, right); // [1,2,3] [4,5]

    // Memory layout inspection
    #[repr(C)]
    struct Point {
        x: f32,
        y: f32,
        z: f32,
    }
    println!("size_of Point: {}", std::mem::size_of::<Point>()); // 12
    println!("align_of Point: {}", std::mem::align_of::<Point>()); // 4

    // Alignment of different types
    println!("align u8:   {}", std::mem::align_of::<u8>()); // 1
    println!("align u64:  {}", std::mem::align_of::<u64>()); // 8
    println!("align &str: {}", std::mem::align_of::<&str>()); // 8 (ptr size)
}
