import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(var dest: Int, var value: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return value - other.value
    }
}

const val INF = Int.MAX_VALUE
val arr = ArrayList<ArrayList<Node>>()
val result = IntArray(20001) { INF }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val k = readLine().toInt()

    for (i in 0..v) {
        arr.add(ArrayList())
    }
    
    for (i in 0 until e) {
        val st2 = StringTokenizer(readLine(), " ")
        val x = st2.nextToken().toInt()
        val y = st2.nextToken().toInt()
        val z = st2.nextToken().toInt()
        arr[x].add(Node(y, z))
    }

    dijkstra(k)
    
    for (i in 1..v) {
        if (result[i] == INF)
            print("INF\n")
        else 
            print("${result[i]}\n")
    }
}

fun dijkstra(k: Int) {
    val pq = PriorityQueue<Node>()
    result[k] = 0
    
    pq.add(Node(k, 0))
    
    while(pq.isNotEmpty()) {
        val node = pq.poll()
        val dest = node.dest
        val value = node.value
        
        for (i in 0 until arr[dest].size) {
            val nextDest = arr[dest][i].dest
            val nextValue = value + arr[dest][i].value
            
            if (result[nextDest] > nextValue) {
                result[nextDest] = nextValue
                pq.add(Node(nextDest, nextValue))
            }
        }
    }
}