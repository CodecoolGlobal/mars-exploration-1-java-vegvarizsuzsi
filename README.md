<a name="readme-top"></a>


<!-- PROJECT LOGO -->
<br />
<div align="center">

![Mars](https://github.com/CodecoolGlobal/mars-exploration-1-java-vegvarizsuzsi/blob/development/src/main/resources/mars-mission.jpg)

<h3 align="center">MARS MAP GENERATOR</h3>
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
      <a href="#introduction">Introduction</a></li>
    <li><a href="#configuration">Configuration</a></li>       
    <li><a href="#contact">Contact</a></li>    
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

People always talk about the weather, and they're also always checking the weather in native and web applications. So We create our own web-based Weather application!
<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

The project is structured to adhere to SOLID principles and other design principles such as SLAP and YAGNI. It includes well-organized classes and modular code to handle the complexity of map generation.

* Java
* SOLID principles


<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- INTRODUCTION -->
## Introduction

The colonization of Mars is an ambitious endeavor, and to avoid wasting valuable resources, extensive simulation exercises are required here on Earth.
The first task at hand is to create an application that can generate randomized maps of Mars, which will be used to calibrate the Mars rovers' software.

In this initial phase, the application is tasked with generating four types of objects on the Martian map:  
`Mountains (^):` Patch-like terrain elements covering a 2D continuous area.  
`Pits (#):` Patch-like terrain elements covering a 2D continuous area.   
`Minerals (*):` Point-like resources.  
`Pockets of Water (~):` Point-like resources.

These maps will be generated based on input requirements defined in a configuration object.
The configuration object will specify the file name for saving the results and the width of the square map. It will also contain parameters for:
The areas covered by different terrain elements (e.g., the required areas for mountains and pits).
The placement of mineral resources near mountain regions.
The placement of pockets of water near pits.
Strategies for generating realistic map shapes and arrangements.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Configuration
To define the requirements for the resulting map, you'll use a configuration object. This object should contain the following parameters:

`file_name:` The name of the file to save the generated map.  
`map_width:` The width of the square map.  

Additionally, the configuration object should specify the most important parameters for terrain elements and resources, such as:  
`mountain_regions:` An array indicating the number of mountain regions and their respective areas.  
`pit_regions:` An array indicating the number of pit regions and their respective areas.  
`mineral_count:` The number of mineral resource points to be placed near mountain regions.  
`water_count:` The number of pockets of water to be placed near pit regions. 


Ensure that the configuration object reflects the specific requirements of your simulation.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Zsuzsi Végvári - [@Zsuzsi Végvári_LinkedIn](https://www.linkedin.com/in/zsuzsiv%C3%A9gv%C3%A1ri/)  
Noémi Varga - [@Noémi Varga_LinkedIn](https://www.linkedin.com/in/noemi-varga-ba021060?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BVaz10imJQ9aW7%2FCOiHT8wg%3D%3D)  
Tímea Tamasi - [@Tímea Tamasi_LinkedIn](https://www.linkedin.com/in/timea-tamasi?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3B54R4iAY9QGay7%2Bw%2B8F89yA%3D%3D)  

Project Link: [https://github.com/CodecoolGlobal/mars-exploration-1-java-vegvarizsuzsi](https://github.com/CodecoolGlobal/mars-exploration-1-java-vegvarizsuzsi)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

[def]: https://developer.mozilla.org/static/img/web-docs-sprite.22a6a085fc69.png

