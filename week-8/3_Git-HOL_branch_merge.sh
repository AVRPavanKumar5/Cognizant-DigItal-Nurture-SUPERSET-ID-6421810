#!/bin/bash
# Branching and Merging Hands-on Lab

echo "Creating new branch GitNewBranch..."
git branch GitNewBranch
git branch -a
git checkout GitNewBranch

echo "Adding files to branch..."
echo "Sample content" > sample.txt
git add sample.txt
git commit -m "Add sample.txt in GitNewBranch"

echo "Switching to master and checking differences..."
git checkout master
git diff GitNewBranch
# Assuming P4Merge is installed and configured
p4merge

git merge GitNewBranch
git log --oneline --graph --decorate

git branch -d GitNewBranch
git status
