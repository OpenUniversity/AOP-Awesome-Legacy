#!/bin/bash
function lic()
{
 cat "header.txt" $1 >tmp
 cp tmp $1
}

for a in $(find -name '*.java')
do
 lic $a
done
