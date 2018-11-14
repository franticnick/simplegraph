# Simplegraph
Simplegraph is android library for simple graph view that is similar to the ones you see on coin exchange sites.

Id you clone the whole project above, there is a sample app that uses simplegraph library located in module "simplebraph". There you can see how view is used.

I've spent so much time looking for library that does only one thing, creates simple graph of coin prices. Sure, there are already some nice libraries out there that can do the job, but I needed something simple and tiny. And that is why I had to create "Simplegraph" :) So, if anyone needs same functionality in their projects, please use it.

Usage is simple as posible. View takes series of float numbers (Y axis points) and drows the graph based on the values. X-axis point values are not needed since library uses same spacing between each consecutive point.

To use view in your own project simply define

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
