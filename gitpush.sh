git add -A
read commitMessage
git commit -m "$commitMessage"
read branch
git push origin $branch