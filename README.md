# Simplegraph
Simplegraph is android library for simple graph view that is similar to the ones you see on coin exchange sites.

Id you clone the whole project above, there is a sample app that uses simplegraph library located in module "simplebraph". There you can see how view is used.

I've spent so much time looking for library that does only one thing, creates simple graph of coin prices. Sure, there are already some nice libraries out there that can do the job, but I needed something simple and tiny. And that is why I had to create "Simplegraph" :) So, if anyone needs same functionality in their projects, please use it.

Usage is simple as posible. View takes series of float numbers (Y axis points) and drows the graph based on the values. X-axis point values are not needed since library uses same spacing between each consecutive point.

To use view in your own project simply use graph view in your project, like:

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

![Alt text](img/screenshot.jpeg?raw=true "Screenshot")
