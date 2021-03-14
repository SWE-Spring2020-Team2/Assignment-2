<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo_name, twitter_handle, email, project_title, project_description
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Assignment 2 - Gilded Rose Refactoring Kata

## Code Test Completion
<blockquote class="imgur-embed-pub" lang="en" data-id="a/FTJUwhi"  ><a href="//imgur.com/a/FTJUwhi">SWE 6733 Team 2 - Assignment 2 - Test Coverage Results</a></blockquote><script async src="//s.imgur.com/min/embed.js" charset="utf-8"></script>   


## Mob Video
* [Link Will Go Here]()

### Built With

* [Discord](https://www.discord.com)
* [Github](https://www.github.com)
* [Trello](https://trello.com/en-US)
* [Java](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)
* [Visual Studio Code](https://code.visualstudio.com/download)


### Rationale Behind Code Choices
Used the project specifications to cover possible JUnit test scenarios prior to refractoring. This helped ensure new errors were not introduced in the final code. Noticed the code included extensive if statements, which made the code difficult to read. Extracted key nested if statements into methods to increase readability. After extraction, found many lines of codes were duplicated and were able to replace those lines of codes with additional methods. Completed additional refactoring for good programing practices (e.g. a = a - a vs a = 0)



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites
* Git (v2.26 at least)
* GitClient / Source Control Tool
* Script Editor (Visual Studio Code preferred) 
* Java SDK 15.0.2

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/JohnMurwin/SWE6733T2-GamingBehavioralMatchmakingSystem.git
   ```
2. Initialize GitFlow using:
   ```sh
   Master Branch: main  
   Develop Branch: develop
   Feature Prefix: feature/
   Release Prefix: release/
   Hotfix Prefix: hotfix/
   Version Tag Prefix: v
   ```
   _Note:_ If you are not utilizing Command Line, or a Client that pre-locks GitFlow you will need to keep the above naming convention in mind as you will need to manually create your branch names following this pattern.


<!-- USAGE EXAMPLES -->
## Usage

Follows standard Java and SWE Developer Guidelines



<!-- CONTRIBUTING -->
## Branch Workflow

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Clone the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request using Standard PR Template. 


<!-- LICENSE -->
## License

Apache License, General Distribution, John Murwin: 2021. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

John Murwin: Lead Developer - [@JohnMurwin](https://twitter.com/JohnMurwin) - john.murwin@gmail.com / jmurwin@students.kennesaw.edu

Christopher Baxter: Documentation & Software Testing - [@]() - baxtercrb9@gmail.com

Bui Tu: Developer  - [@]() - Tlaaron104@gmail.com

Thade Huichapa: Developer - [@]() - thaidehuichapa@gmail.com

L. Renee: Scrum Master - [@]() - ldavisto@students.kennesaw.edu




<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [@Othneildrew](https://github.com/othneildrew)
* [@stevemao](https://github.com/stevemao)
* [@Allar](https://github.com/Allar)



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo.svg?style=for-the-badge
[contributors-url]: https://github.com/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo.svg?style=for-the-badge
[forks-url]: https://github.com/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo/network/members
[stars-shield]: https://img.shields.io/github/stars/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo.svg?style=for-the-badge
[stars-url]: https://github.com/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo/stargazers
[issues-shield]: https://img.shields.io/github/issues/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo.svg?style=for-the-badge
[issues-url]: https://github.com/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo/issues
[license-shield]: https://img.shields.io/github/license/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo.svg?style=for-the-badge
[license-url]: https://github.com/SWE-Spring2020-Team2/SWE6733T2-GamingBehavioralMatchmakingSystem/repo/blob/master/LICENSE.txt
