library(ggplot2)
library(reshape2)
library(gridExtra)

write_box_plots <- function(language, experiment) {
  exec_time_fp <- scan(paste0(language, '-fp/', experiment, '/exec_times.txt'), nlines = 10)
  exec_time_oop <- scan(paste0(language, '-oop/', experiment, '/exec_times.txt'), nlines = 10)
  cpu_usage_fp <- scan(paste0(language, '-fp/', experiment, '/cpu_averages.txt'), nlines = 10)
  cpu_usage_oop <- scan(paste0(language, '-oop/', experiment, '/cpu_averages.txt'), nlines = 10)
  mem_usage_fp <- scan(paste0(language, '-fp/', experiment, '/mem_averages.txt'), nlines = 10)
  mem_usage_oop <- scan(paste0(language, '-oop/', experiment, '/mem_averages.txt'), nlines = 10)
  energy_usage_fp <- scan(paste0(language, '-fp/', experiment, '/energy_totals.txt'), nlines = 10)
  energy_usage_oop <- scan(paste0(language, '-oop/', experiment, '/energy_totals.txt'), nlines = 10)
  
  plot_box <- function(data1, data2, title, filename) {
    df1 <- data.frame(y=data1, group="FP", stringsAsFactors = FALSE)
    df2 <- data.frame(y=data2, group="OOP", stringsAsFactors = FALSE)
    df <- rbind(df1, df2)
    
    p <- ggplot(df, aes(x=group, y=y, fill=group)) +
      geom_boxplot() +
      labs(title=title) +
      scale_fill_manual(values=c("FP"="#1b5e27", "OOP"="#593a11")) +
      theme(axis.title.x=element_blank())  # Hide x-axis title if not needed
    
    return(p)
  }
  
  p1 <- plot_box(exec_time_fp, exec_time_oop, "Execution Time (s)", NULL)
  p2 <- plot_box(cpu_usage_fp, cpu_usage_oop, "CPU Usage (%)", NULL)
  p3 <- plot_box(mem_usage_fp, mem_usage_oop, "Memory Usage (KB)", NULL)
  p4 <- plot_box(energy_usage_fp, energy_usage_oop, "Energy Usage (Joules)", NULL)
  
  pretty_languages <- c("py" = "Python", "sc" = "Scala", "rs" = "Rust")
  pretty_experiments <- c("arrayiteration" = "Array Iteration", "bfs" = "Breadth-First Search", "bubblesort" = "Bubble Sort", "dfs" = "Depth-First Search", "fib" = "Fibonacci Sequence", "filter" = "Filtering", "matrix_mul" = "Matrix Multiplication", "merge" = "Merge Sort")
  combined_title <- paste(pretty_languages[language], pretty_experiments[experiment], "Performance Metrics")
  combined_plot <- gridExtra::grid.arrange(p1, p2, p3, p4, ncol=2, top=combined_title)
  
  ggsave(paste0("figures/", language, "_", experiment, "_combined.png"), combined_plot)
  
}

languages <- c('py', 'sc', 'rs')
experiments <- c('arrayiteration', 'bfs', 'bubblesort', 'dfs', 'fib', 'filter', 'matrix_mul', 'merge')

for (lang in languages) {
  for (exp in experiments) {
    write_box_plots(lang, exp)
  }
}