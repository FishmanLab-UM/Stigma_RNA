for i in *.split.bam; do htseq-count -f bam --nonunique=all --stranded=no --type=gene --idattr=Name --a 0 $i /scratch/evan/MimulusRPs_6/Allelic_ID_IM62_SF5.gff3 > ${i:0:-43}.counts.tsv;done
