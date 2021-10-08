# ProductStore


<div id="top"></div>



<!-- PROJECT LOGO -->
<br />
<div align="center">

  <a href="https://github.com/CarlosOlles/ProductStore">
    <img src="images/logo.jpg" alt="Logo" width="500" height="200">
  </a>

<h3 align="center">Product Store Automation</h3>

  <p align="center">
    Project for automating demoblaze.com
    <br />
    <a href="https://github.com/CarlosOlles/ProductStore"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/CarlosOlles/ProductStore">View Demo</a>
    ·
    <a href="https://github.com/CarlosOlles/ProductStore/issues">Report Bug</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
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
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Maven](https://maven.apache.org/)
* [JUnit 5](https://junit.org/junit5/)
* [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
* [Selenium Grid](https://www.selenium.dev/documentation/grid/)
* [Docker](https://www.docker.com/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

In order to use this project, you have to install docker-compose on your local machine.

### Prerequisites

* [Install Docker compose](https://docs.docker.com/compose/install/)
  ``` sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
      sudo chmod +x /usr/local/bin/docker-compose
      sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
  ```

### Usage

1. Launch docker-compose.yml
   ```
   docker-compose up -d
   ```
2. Check that Selenium Grid is up & running under localhost:4444
   ```
   curl http://localhost:4444/status
   ```
3. Launch the tests
   ```
   mvn clean compile test -DbrowserName=chrome
   ```

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- ROADMAP -->
## Roadmap

- [] Image comparison for generic assertions
- [] Cookie export & import to separate the tests under 3 different methods
- [] Fix video recording docker image (currently generating videos but those aren't reproducible)
- [] Generate literal.properties file to read all literals from there


See the [open issues](https://github.com/CarlosOlles/ProductStore/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Carlos Ollés - [@c_olles](https://twitter.com/c_olles) - carlosolles31@gmail.com

Project Link: [https://github.com/CarlosOlles/ProductStore](https://github.com/CarlosOlles/ProductStore)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/CarlosOlles/ProductStore.svg?style=for-the-badge
[contributors-url]: https://github.com/CarlosOlles/ProductStore/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CarlosOlles/ProductStore.svg?style=for-the-badge
[forks-url]: https://github.com/CarlosOlles/ProductStore/network/members
[stars-shield]: https://img.shields.io/github/stars/CarlosOlles/ProductStore.svg?style=for-the-badge
[stars-url]: https://github.com/CarlosOlles/ProductStore/stargazers
[issues-shield]: https://img.shields.io/github/issues/CarlosOlles/ProductStore.svg?style=for-the-badge
[issues-url]: https://github.com/CarlosOlles/ProductStore/issues
[license-shield]: https://img.shields.io/github/license/CarlosOlles/ProductStore.svg?style=for-the-badge
[license-url]: https://github.com/CarlosOlles/ProductStore/blob/master/LICENSE.txt
[linkedin-url]: https://www.linkedin.com/in/carlos-olles/
[product-screenshot]: images/screenshot.png
