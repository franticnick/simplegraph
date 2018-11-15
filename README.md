# Simplegraph
Simplegraph is Android custom view that can generate graphs similar to the ones you see on coin trading/exchange sites.

If you clone the whole project, main app is a sample app that you can run and see simplegraph functionality in action.

Why this library is out there? Well, I've spent too much time looking for library that does only one thing, and that is, creates graph for simple representation of values over time. Sure, there are already some nice libraries out there that can do the job, but I needed something super simple and tiny. And that is why I had to create "Simplegraph". And now, if anyone needs same functionality in their projects, here it is.

Usage is as simple as posible. View takes series of float numbers (Y axis points) and draws the graph. X-axis point values are not needed since library uses same spacing between each consecutive point.

## Sample Usage

To use view in your own project simply use linegraph view in your project, like:

~~~xml
<com.bandiago.libs.simplegraph.LineGraph
            xmlns:linegraph="http://schemas.android.com/apk/res-auto"
            android:id="@+id/lineGraph"
            android:layout_width="200dp"
            android:layout_height="50dp"
            
            linegraph:lineThickness="2"
            linegraph:lineColor="#000000"
            
            android:background="#e2d3d3"/>
~~~

There are two properties you can use in the view. Their names are self-explanatory:
 - <span style="color:blue">lineThickness</span>
 - <span style="color:blue">lineColor</span>
 

and then in your code you can do something like this:

~~~kotlin
        val lineGraph = findViewById<LineGraph>(R.id.lineGraph)
        val series = arrayOf(0f, 1f, 2f, 8f, 5f, 13f, 4f, 3f, 0f)
        lineGraph.addSeries(series)
~~~

The result for this simple setup would be:

![Alt text](img/screenshot.jpg?raw=true "Screenshot")

To include simple graph to your project, simply add next line to app's **build.gradle** file

~~~gradle
dependencies {
    implementation 'com.bandiago.libs:simplegraph:0.0.2'
}
~~~

## License

~~~
Copyright 2018 Nikola Šoljaga

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~
