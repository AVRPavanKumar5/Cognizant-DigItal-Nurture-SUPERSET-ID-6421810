#!/bin/bash
# Conflict Resolution Hands-on Lab

echo "Creating GitWork branch and adding hello.xml..."
git checkout master
git checkout -b GitWork
echo "<msg>Hello from branch</msg>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in GitWork"

echo "Switching to master and adding different hello.xml..."
git checkout master
echo "<msg>Hello from master</msg>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in master"

git log --oneline --graph --decorate --all
git diff GitWork

# Use P4Merge for visualization
p4merge

echo "Merging branch into master..."
git merge GitWork || echo "Merge conflict detected!"

# Manual or 3-way merge resolution steps here
# After resolving:
git add hello.xml
git commit -m "Resolved merge conflict in hello.xml"

echo "*.bak" >> .gitignore
git add .gitignore
git commit -m "Add .gitignore entry for .bak files"

git branch -d GitWork
git log --oneline --graph --decorate
