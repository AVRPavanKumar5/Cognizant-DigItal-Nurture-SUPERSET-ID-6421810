#!/bin/bash
# Cleanup and Push to Remote Hands-on Lab

git checkout master
git status
git branch -a

git pull origin master

echo "Pushing pending changes from Git-T03-HOL_002..."
git push origin master

echo "Check remote repository for changes."
