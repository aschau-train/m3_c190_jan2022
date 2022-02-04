# A typical pattern when using git and github
## Getting a copy of an existing project on the local machine
* Change to a directory that is NOT under git management (nesting git repositories causes problems with where push and pull and looking)
> git clone urlOfGithubRepo
* cd into the project directory
## Working with changes in main (master)
* Confirm that the current branch is main (older repos might use master as the main branch instead)
> git branch (the one with the * is current)
* Make changes to code as necessary
* Add the changes to the staging area of the local git
> git add --all
or
> git add FolderName/
* Commit the changes to the local repository
> git commit -m "Commit message is..."
* Push the changes to the remote repository
> git push
* Check any error message and handle the issues
## Working in a new branch
* Make sure the main (or master) branch is up to date with the remote repo
> git checkout main
* Always get the latest source from the remote repo
> git pull
* Create the new local work branch
> git checkout -b featurebranch
* Now make changes as needed in the featurebranch.  When ready add and commit those changes locally
> git add --all
* Then commit these locally
> git commit -m "New features"
* Push the branch up to the remote repository
> git push --set-upstream origin featurebranch
## Switch to github
* Confirm the changes have been pushed by selecting the new branch in github
* Create a pull request in github explaining the purpose for the branch and that it is ready to merge into the main branch
* Someone else will review and approve the pull request (they refer to a pull request as  PR)
* The branch can now be merged with the main branch
# Back on the local machine
* Switch to the main branch
> git checkout main
* Pull the latest changes from the remote repo to the local machine
> git pull
* Switch the the working branch
> git checkout featurebranch
* And merge the latest changes into your branch
> git merge main
