object main {
  import scala.io.StdIn.readInt
  import scala.util.Random
  import scala.collection.mutable.ListBuffer
  
  def main(arg: Array [String]){
    print("Harvest Statistic Problem\n\n")
    
    println("Let's assume there are 4 weeks and 7 days per week and 1st day of the month(February) is Monday")
    println("For demonstration pourposes I have initialize random data on each day of the week\n")
    
    println("Let's get started")
    
    var option = 1;
    var harvestRecords = Array.ofDim[Int](4,7);
    addRandomHarvestRecords(harvestRecords)
    
    while(option != 4){
      println("1 - Update Harvest Records")
      println("2 - Print Harvest Records")
      println("3 - Show Staticstics")
      println("4 - Done")
      
      print("Enter your option : ");
      option = readInt();
      
      option match{
        case 1 => updateHarvest(harvestRecords)
        case 2 => printHarvest(harvestRecords)
        case 3 => showStatistics(harvestRecords)
        case 4 => println("Done\n")
        case _ => println("Invalid Input\n")
      }
    }
   
  }
  
  def showStatistics(h:Array[Array[Int]]) = {
     val max = findMax(h);
    
    val min = findMin(h);
    
//    val range = max - min
    println("Range of the harvest : "+(max-min)+"\n")
    
    val avg = findAvg(h);
    println("Average value of the harvest : "+avg+"\n")
    
    val median = findMedian(h);
    println("Median value of the harvest : "+median+"\n")
  }
  
  def findMax(h:Array[Array[Int]]):Int = {
    var max = h(0)(0)
    val list = new ListBuffer[List[Int]]()
    for(i <- 0 to 3;j <- 0 to 6){
      if(max<h(i)(j)){
        max = h(i)(j)
        list.clear();
        list += List(i,j)
      }else if(max==h(i)(j)){
        list += List(i,j)
      }
    }
    println("\nMaximum harvest is : " + max);
    for(item <- list){
      println("Found "+getWeekDay(item(1)+1)+", February "+(item(0)*7+item(1)+1)+", 20XX")
    }
    println()
    return max
  }
  
  def findMin(h:Array[Array[Int]]):Int = {
    var min = h(0)(0)
    val list = new ListBuffer[List[Int]]()
    for(i <- 0 to 3;j <- 0 to 6){
      if(min>h(i)(j)){
        min = h(i)(j)
        list.clear();
        list += List(i,j)
      }else if(min==h(i)(j)){
        list += List(i,j)
      }
    }
    println("Minimum harvest is : " + min);
    for(item <- list){
      println("Found "+getWeekDay(item(1)+1)+", February "+(item(0)*7+item(1)+1)+", 20XX")
    }
    println()
    return min
  }
  
  def findAvg(h:Array[Array[Int]]):Double = {
    val list = getList(h)
    println(list)
    return list.sum/list.length
  }
  
  def findMedian(h:Array[Array[Int]]):Double = {
    var list = getList(h)
    list = list.sorted
    val l = list.length
    if(l%2 == 0)
      return (list(l/2-1)+list(l/2))/2
    else
      return list(l/2-1)
  }
  
  def getList(h:Array[Array[Int]]):ListBuffer[Int] = {
    val list = new ListBuffer[Int]()
    for(i <- 0 to 3;j <- 0 to 6){
      list += h(i)(j)
    }
    return list
  }
  
  def getWeekDay(d:Int):String = {
    d match{
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case 7 => "Sunday"  
    }
  }
  
  def addRandomHarvestRecords(h:Array[Array[Int]]) = {
    val r = new Random();
    for(i <- 0 to 3){
      for(j <- 0 to 6){
        h(i)(j) = r.nextInt(50)
      }
    }
  }
  
  def printHarvest(h:Array[Array[Int]]) = {
    println("\n\tDay_1\t"+"Day_2\t"+"Day_3\t"+"Day_4\t"+"Day_5\t"+"Day_6\t"+"Day_7\t")
    for(i <- 0 to 3){
      print("Week_"+(i+1)+"\t")
      for(j <- 0 to 6){
        print(h(i)(j)+"\t")
      }
      println();
    }
    println()
  }
  
  def updateHarvest(h:Array[Array[Int]]) = {
     print("\nEnter day to update : ");
     var day = readInt();
     while(day<=0 || day>28){
       println("Day should be between 1 and 28")
       print("\nEnter day to update : ");
       day = readInt();
     }
     print("Enter harvest : ");
     var harvest = readInt();
     while(harvest<0){
       println("Harvest cannot be negative")
       print("Enter harvest : ");
       harvest = readInt();
     }
     h((day-1)/7)((day-1)%7) = harvest;
     println("Week_ "+((day-1)/7+1)+" Day_" +((day-1)%7+1)+" harvest updated to "+harvest+"\n")
     
  }
  
}