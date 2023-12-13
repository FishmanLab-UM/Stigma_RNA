num="
list_of_fastq.gz_files
"

for n in ${num} 
do echo ${n}; gunzip ${n}
done