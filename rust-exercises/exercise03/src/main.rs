// Implementing From<io::Error> for ConfigError lets the ? operator automatically convert IO errors.
// This is the idiomatic way to build ergonomic error propagation chains in Rust.

use std::collections::HashMap;
use std::fmt;
use std::io;

#[derive(Debug)]
enum ConfigError {
    FileMissing(String),
    ParseError { line: usize, msg: String },
    MissingKey(String),
}

impl fmt::Display for ConfigError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            ConfigError::FileMissing(path) => write!(f, "Config file not found: {}", path),
            ConfigError::ParseError { line, msg } => {
                write!(f, "Parse error on line {}: {}", line, msg)
            }
            ConfigError::MissingKey(key) => write!(f, "Required key missing: {}", key),
        }
    }
}

impl std::error::Error for ConfigError {}

// From<io::Error> enables `?` to auto-convert IO errors.
impl From<io::Error> for ConfigError {
    fn from(e: io::Error) -> Self {
        ConfigError::FileMissing(e.to_string())
    }
}

fn parse_config(path: &str) -> Result<HashMap<String, String>, ConfigError> {
    let content = std::fs::read_to_string(path)?; // io::Error → ConfigError
    let mut map = HashMap::new();
    for (i, line) in content.lines().enumerate() {
        let line = line.trim();
        if line.is_empty() || line.starts_with('#') {
            continue;
        }
        let (key, val) = line
            .split_once('=')
            .ok_or_else(|| ConfigError::ParseError {
                line: i + 1,
                msg: format!("expected 'key=value', got: {}", line),
            })?;
        map.insert(key.trim().to_string(), val.trim().to_string());
    }
    Ok(map)
}

fn get_required<'a>(map: &'a HashMap<String, String>, key: &str) -> Result<&'a str, ConfigError> {
    map.get(key)
        .map(|s| s.as_str())
        .ok_or_else(|| ConfigError::MissingKey(key.to_string()))
}

fn main() {
    match parse_config("app.conf") {
        Ok(cfg) => match get_required(&cfg, "database_url") {
            Ok(url) => println!("DB: {}", url),
            Err(e) => eprintln!("Config error: {}", e),
        },
        Err(e) => eprintln!("Failed to load config: {}", e),
    }
}

// Key Takeaways
// The ? operator is syntactic sugar for: match result { Ok(v) => v, Err(e) => return Err(From::from(e)) }.
// Implementing From conversions between error types is therefore the key to ergonomic propagation.
// The anyhow and thiserror crates eliminate most of this boilerplate in real projects.
