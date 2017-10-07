# CNU Github manual

This manual tells you how to create a new Github repository with your project and how to set up GIT in your IDEA Community Edition.

## Github repository

1. Create a [Github account](https://github.com/join), don't worry, it's free! Login to this account.
2. View the [CNU Rover repository](https://github.com/Wrent/cnu-mars-rover) (TODO change to CN link)
3. Click on the Fork button in the top right corner. This will create a copy of this repository in your account,
where you can continue with development of your homework without influencing the others.

## GIT integration with IntelliJ IDEA CE

1. Make sure that you have [GIT](https://git-scm.com/downloads) installed. Default instal location on Windows is `C:\Program Files\Git\cmd\git.exe`.
2. Open your IDEA, go to Setings (File -> Settings) -> Version Control -> Git.
3. Set "Path to git executable" to the location of your `git.exe`. Click Test button to make sure it works. Submit settings.
4. Create new Idea project from Version Control
    a. In Welcome to IDEA window, choose Checkout from Version Control -> Git and put down the address of your repository
    b. In classical window, click File -> New -> Project from Version Control -> Git and put down the address of your repository
    c. (you might need to set a new directory for it if it conflicts with the project from the training)
5. When you open this new project, the IDE should show a popup in the left bottom corner, where you should click on Import gradle project
and confirm the next dialog
6. If this popup does not show, you can open the project as gradle project from File -> New -> Project with existing sources..., you should
locate your project and select the gradle.build file. The cloned repository should be in your `C:/Users/username/IdeaProjects` folder.
7. Now you should be able to view your Version Control panel (View -> Tool windows -> Version control), in that panel, you can click Log and
you should see historical commits from the training.
    

## How to use GIT in IDEA

1. When your project is linked to a GIT repository, every time you make a change to a file, you can see that the color of it's filename changes to blue.
You can also see that the new files have green color. This marks that these files contain some changes.
2. If you want to commit some changes (e.g. after you wrote a new test or a new functionality) you can commit it by pressing CTRL+K. A new
window will appear, where you can review the changes and write some message about the changes, so you can easily identify it in the future.
3. You can check Reformat code and Optimize imports checkboxes, you can uncheck Perform Code analysis and TODO analysis.
4. When you are happy with your changes, you can commit the code. You can see you commit in the Log panel.
5. Remember, that GIT first commits your changes only to your local copy of your repository in your computer. To push the changes to the
repository on Github, where we can see it too, you need to press CTRL + SHIFT + K and push your commits to the Github.

## Troubles?

Contact me (Adam) or anyone else on Slack and we will try to help you.
