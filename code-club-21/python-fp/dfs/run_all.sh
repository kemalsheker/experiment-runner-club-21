#!/bin/bash

executor='python'
program='script.py'

calculate_average_cpu() {
  # Initialize sum and line_count variables
  sum=0
  line_count=0
  first_line=true

  # Read file line by line
  while IFS= read -r line; do
    # Skip the first line
    if [ "$first_line" = true ]; then
      first_line=false
      continue
    fi

    # Add the line value to the sum
    sum=$(echo "$sum + $line" | bc)
    
    # Increment the line count
    ((line_count++))
  done < "experiments/experiment/run_0/raw_data.csv"

  # Calculate the average and divide it by 4
  if [ $line_count -ne 0 ]; then
    average=$(echo "scale=2; $sum / $line_count" | bc)
    average_divided_by_4=$(echo "scale=2; $average / 4" | bc)
    echo "$average_divided_by_4"  # Output this average for collection
  else
    echo "0"  # Output zero if the file is empty, does not exist, or has only one line
  fi
}

get_total_power() {
	energy=$(awk -F, '$2=="DONE" {print $3}' experiments/experiment/run_table.csv)

  echo "$energy"
}

calculate_avg_mem() {
  # Initialize sum and line_count variables
  sum=0
  line_count=0

  # Read file line by line
  while IFS= read -r line; do
    # Add the line value to the sum
    sum=$(echo "$sum + $line" | bc)
    
    # Increment the line count
    ((line_count++))
  done < "mem_output.txt"

  # Calculate the average and divide it by 4
  if [ $line_count -ne 0 ]; then
    average=$(echo "scale=2; $sum / $line_count" | bc)
    average_divided_by_4=$(echo "scale=2; $average / 4" | bc)
    echo "$average_divided_by_4"  # Output this average for collection
  else
    echo "0"  # Output zero if the file is empty, does not exist, or has only one line
  fi
}

calculate_exec_time()
{
  start=$(date +%s)
  eval $executor $program
  end=$(date +%s)

  duration=$((end - start))
  echo "$duration"
}

sum_of_averages=0

avg_of_avg_cpu() 
{
	for i in {1..10}; do

	  rm -rf experiments/
	  python ../../experiment-runner/experiment-runner conf_template_cpu.py

	  avg=$(calculate_average_cpu)

	  echo "$avg" >> "cpu_averages.txt"
	  sum_of_averages=$(echo "$sum_of_averages + $avg" | bc)
	done
}

avg_of_total_power()
{
	for i in {1..10}; do

	  rm -rf experiments/
	  python ../../experiment-runner/experiment-runner conf_template_power.py

	  total_power=$(get_total_power)

	  echo "$total_power" >> "energy_totals.txt"
	done
}

avg_of_avg_mem()
{
	for i in {1..10}; do
		
		if [ -f "mem_output.txt" ]; then
			rm mem_output.txt
		fi
		rm -rf experiments/
	    python ../../experiment-runner/experiment-runner conf_template_mem.py

		avg_mem=$(calculate_avg_mem)

		echo "$avg_mem" >> "mem_averages.txt"
	done
}

avg_of_exec_time()
{
	for i in {1..10}; do
		
		exec_time=$(calculate_exec_time)

		echo "$exec_time" >> "exec_times.txt"
	done
}

main() 
{
	avg_of_avg_cpu
	avg_of_total_power
	avg_of_avg_mem
	avg_of_exec_time

	if [ -f "mem_output.txt" ]; then
			rm mem_output.txt
		fi
}

main "${@}"

exit 0
