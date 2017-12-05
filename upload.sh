#! /bin/bash
# created 11/27/2017
# upload files to git

TEXT="Added blackjack test class, phases, splitting hands, double downing, and extra files"

clear
# echo $TEXT
git add .
git commit -m "$TEXT"
git push origin master
