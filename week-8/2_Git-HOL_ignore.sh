#!/bin/bash
# Git Ignore Hands-on Lab
# Create .log file and log folder, update .gitignore, verify status

echo "Creating log file and log folder..."
touch test.log
mkdir log
echo "*.log" >> .gitignore
echo "log/" >> .gitignore

git status
