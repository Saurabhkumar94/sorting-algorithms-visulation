* Sorting Algorithms Simulator

* Sorting Algorithms simulator and visualizer program made with java processing

[Cover](graphics/thumb.png)

* Overview

* Contains several in-built Sorting Algorithms, with first hand support for implementing custom algorithms
* Real-time colorful visualisation of algorithm parameters, iteration and values
* Both command line and graphical interface controls
* Change the data size, algorithm speed, sort order, color scheme etc

&[Quick Sort](graphics/quick_light.png)

* Algorithms

| Algorithm              | Key | Avg Time Complexity | Avg Space Complexity |
|------------------------|-----|---------------------|----------------------|
| Bubble Sort            | B   | O(n<sup>2</sup>)    | O(1)                 |
| Insertion Sort         | I   | O(n<sup>2</sup>)    | O(1)                 |
| Selection Sort         | S   | O(n<sup>2</sup>)    | O(1)                 |
| Merge Sort (iterative) | M   | O(nlog(n))          | O(n)                 |
| Quick Sort (iterative) | Q   | O(nlog(n))          | O(n)                 |

&[Merge Sort](graphics/merge_dark.png)

* Configurations and Actions

* `Data Size` : number of entries in the data set to be sorted
* `Speed` : Increase/Decrease algorithm speed (in iterations per second)
* `Sort Order` : target order of the algorithm, Ascending or Descending
* `Shuffle` : randomly shuffle the input data
* `Reset` : reset input data or algorithm to initial state
* `Pause / Resume` : pause/resume algorithm at any iteration
* `Theme` : toggle between light and dark themes
* `Fullscreen` : To start as fullscreen, set the `fullscreen = 1` flag in `config.ini` settings file

&[Insertion Sort](graphics/insertion_light.png)

* Usage

* Install [Java](https://www.oracle.com/in/java/technologies/downloads/) on your computer and add it to the path  
  `
* Navigate to `out\artifacts\SortingGl_jar` and run `launch.bat`.  
  Optionally, open up the terminal and run `java -jar SortingGl.jar`

&[Command Line Interface](graphics/cli_light_sorting.png)

* Commands

* `algo [key]` : set sorting algorithm
* `size [+/-/count]` : increase / decrease / set data size
* `speed [+/-/percent]` : increase / decrease / set sorting speed
* `invert` : Invert sorting order
* `reset [f]` : Reset [force]
* `theme` : toggle ui theme [LIGHT/DARK]
* `start/resume` : start / resume sorting
* `pause` : pause sorting
* `stop` : stop sorting
* `exit/quit` : quit

&[Selection Sort](graphics/bubble_dark.png)

* UI Controls

* `Algo-Key` : Set the sorting algorithm
* `Space`: Play/Pause
* `Ctrl-[Shift]-R` : Reset [force]
* `Ctrl-I` : Invert sort order
* `+/-` : Increase / decrease sorting speed
* `Ctrl +/-` : Increase / decrease data size
* `Ctrl-T` : Toggle light / dark theme

&[Selection Sort](graphics/selection_light.png)



