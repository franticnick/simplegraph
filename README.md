# Simplegraph
Simplegraph is Android custom view that shows simple graphs similar to the ones you see on coin trading/exchange sites.

If you clone the whole project, main app is a sample that you can run and see how simplegraph library located in module "simplebraph" is used.

Why this library is craeted? Well, I've spent too much time looking for library that does only one thing, and that is, creates graph for simple representation of values over time. Sure, there are already some nice libraries out there that can do the job, but I needed something super simple and tiny. And that is why I had to create "Simplegraph" :) So, if anyone needs same functionality in their projects, here it is.

Usage is simple as posible. View takes series of float numbers (Y axis points) and draws the graph. X-axis point values are not needed since library uses same spacing between each consecutive point.

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

There are two properties you can use in the view which names are self-explanatory:
 - lineThickness
 - lineColor
 

and then in your code you can do something like this:

~~~kotlin
        val lineGraph = findViewById<LineGraph>(R.id.lineGraph)
        val series = arrayOf(0f, 1f, 2f, 8f, 5f, 13f, 4f, 3f, 0f)
        lineGraph.addSeries(series)
~~~

The result for this simple setup would be:

![Alt text](img/screenshot.jpg?raw=true "Screenshot")

To include simple graph to your project, simply add next line to app's build.gradle file

~~~gradle
    implementation 'com.bandiago.libs:simplegraph:0.0.1-SNAPSHOT'
~~~

Also add repository url to project's build.gradle file

~~~gradle
allprojects {
    repositories {
        google()
        jcenter()
        // add sonatype repository
        maven {
            url 'https://oss.sonatype.org/content/repositories/snapshots/'
        }
    }
}
~~~
