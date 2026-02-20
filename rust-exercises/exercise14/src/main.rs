// Clap's derive API generates all argument parsing, help text, and validation from struct/enum definitions.
// Subcommands are expressed as an enum implementing Subcommand, and referenced from the main Parser struct.

use clap::{Parser, Subcommand};
use std::fs;
use std::path::PathBuf;

#[derive(Parser)]
#[command(
    name = "rproc",
    about = "A file processing CLI tool",
    version = "0.1.0",
    author
)]
struct Cli {
    #[command(subcommand)]
    command: Commands,
    /// Enable verbose output
    #[arg(short, long, global = true)]
    verbose: bool,
    /// Write output to FILE instead of stdout
    #[arg(short, long, global = true, value_name = "FILE")]
    output: Option<PathBuf>,
}

#[derive(Subcommand)]
enum Commands {
    /// Count lines, words, and characters
    Count {
        #[arg(value_name = "FILE")]
        file: PathBuf,
    },
    /// Search for a regex pattern
    Search {
        #[arg(value_name = "PATTERN")]
        pattern: String,
        #[arg(value_name = "FILE")]
        file: PathBuf,
    },
    /// Transform text: to-upper | to-lower | reverse
    Transform {
        #[arg(value_name = "MODE")]
        mode: String,
        #[arg(value_name = "FILE")]
        file: PathBuf,
    },
}

fn run(cli: &Cli) -> anyhow::Result<()> {
    let output = match &cli.command {
        Commands::Count { file } => {
            let text = fs::read_to_string(file)?;
            let lines = text.lines().count();
            let words = text.split_whitespace().count();
            let chars = text.chars().count();
            if cli.verbose {
                eprintln!("Counting: {}", file.display());
            }
            format!("lines={} words={} chars={}", lines, words, chars)
        }
        Commands::Search { pattern, file } => {
            let re = regex::Regex::new(pattern)?;
            let text = fs::read_to_string(file)?;
            let found: Vec<_> = text
                .lines()
                .enumerate()
                .filter(|(_, l)| re.is_match(l))
                .collect();
            if cli.verbose {
                eprintln!("{} matches", found.len());
            }
            found
                .iter()
                .map(|(i, l)| format!("{}:{}", i + 1, l))
                .collect::<Vec<_>>()
                .join("\n")
        }
        Commands::Transform { mode, file } => {
            let text = fs::read_to_string(file)?;
            match mode.as_str() {
                "to-upper" => text.to_uppercase(),
                "to-lower" => text.to_lowercase(),
                "reverse" => text.chars().rev().collect(),
                other => anyhow::bail!("Unknown mode: {}", other),
            }
        }
    };

    match &cli.output {
        Some(path) => fs::write(path, &output)?,
        None => println!("{}", output),
    }
    Ok(())
}

fn main() {
    let cli = Cli::parse();
    if let Err(e) = run(&cli) {
        eprintln!("Error: {}", e);
        std::process::exit(1);
    }
}
