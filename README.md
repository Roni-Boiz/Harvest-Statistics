# Harvest-Statistics
This repo provide a modern world solution to Harvest Statistics problem in a state.
Our objective is to record daily harvest quantities and use those records to get statistical reports.
Then we will able to calculate the maximum, minimum, average, and median harvest of a particular month.

> Need Scala version equal or upper than : **2.13.5**

## Solution
We will store the daily harvest of the state in a **Array(row-week, column-day)**.
We assume that each month have 4 week and 7 day for each week so, all together 28 days.

![alt text](img/Picture1.png?raw=true "Array initialization")

For demonstration purposes we have initialize the array with random values.
In line-128 we have passed our array to function `addRandomHarvestRecords()`.

![alt text](img/Picture2.png?raw=true "function addRandomHarvestRecords")

Then by creating random objects we have initialize(update) our array with random values 0-50 (Line-132).
This step can be skip if we are working with actual data. After this step our array will look like this.

Day_1 | Day_2 | Day_3 | Day_4 | Day_5 | Day_6 | Day_7
--- | --- | --- | --- | --- | --- | ---
8	| 5	| 5	| 12	| 16	| 20 | 4
7	| 2	| 8	| 8	| 11 | 14 |	25
17 | 19 |	24 | 4 | 7 | 1 | 3
8	| 5	| 7	| 6	| 27 | 5 | 24
> Array.ofDim\[Int\]\(4,7\)

Our loop structure

![alt text](img/Picture3.png?raw=true "loop structure")

This is the basic while loop we have use to iterate our program. This act as heart of our program. Here we give four options,
1.	Update harvest
2.	Print harvest
3.	Show statistics

### 1. Update Harvest
Update harvest is simple code we let to update any harvest record of particular day.
Since we have initialized our array with random values still you can insert your own data through this method.
Here we take two inputs they are day of the month (Line-150 to Line-151) and the harvest(Line-157 to Line-158).
We also concern about two constraints that are day should be between 1 – 28 (Line-152 to Line-156) and harvest cannot be negative (Line-159 to Line-163)

![alt text](img/Picture4.png?raw=true "function updateHarvestRecords")

Finally, we will give confirmation message about your update (Line-165)

### 2. Print Harvest
Print harvest is general for loop structure to print all data in the array.
 
![alt text](img/Picture5.png?raw=true "function printHarvest")

After this function runs output would look like this.

![alt text](img/Picture6.png?raw=true "output array")
 
### 3. Show Statistics
This is where our core components are defined. The code look like this.

![alt text](img/Picture7.png?raw=true "function showStatistics")

Here we have passed our harvest array for further calculations such as finding minimum, maximum, range, mean, and median. Let’s talk them one by one.


#### 3.1 Find Maximum (Line-39)
Here we will find the maximum by traversing the array. You know there may be several days we will record maximum harvest. 
So that we have use list buffer to record the week number and day of the week of each maximum harvest record (Line-62). 
During traversing, if we encounter record that is more than the current maximum value in the list, 
we will clear the list and add new record to the list (Line-58 to Line-60).

![alt text](img/Picture8.png?raw=true "function findMax")

Finally, we print maximum harvest (Line-65) and traverse the list then print the date we found our maximum harvest record (Line-66 to Line-68).


#### 3.2 Find Minimum (Line-41)
Here we will find the minimum by traversing the array. You know there may be several days we will record minimum harvest. 
So that we have use list buffer to record the week number and day of the week of each minimum harvest record (Line-82). During traversing,
if we encounter record that is more than the current minimum value in the list, we will clear the list and add new record to the list (Line-78 to Line-80).
** same as finding maximum harvest

![alt text](img/Picture9.png?raw=true "function findMin")

Finally, we print maximum harvest (Line-85) and traverse the list then print the date we found our maximum harvest record (Line-86 to Line-88).

For both of these function `getWeekDay()` return whether each day is Monday, Tuesday …. . Depending on item(1)+1. Here item(0) means row of array and item(1) means column of the array.


#### 3.3 Find Range (Line-44)
Range is the difference between maximum and minimum. We have used the value return by above two functions to calculate the range.


#### 3.4 Find Mean (Line-46)
We will pass the harvest array to this function, the by using build in functions, 
we will get a list from array (Line-94) and there are built in functions in list to get sum of all the element in the list and length of the list (Line-96).
By using those functions, we will return the mean(Average) at the end of the function.

![alt text](img/Picture10.png?raw=true "function findAvg")

#### 3.5 Find Median (Line-48)
Here also we will pass our original harvest array and get a list from it (Line-100). 
The we will sort the array using build in function in lists (Line-101). Then we get the median of the harvest record,
if there are even number of records, then we will get median by Line-104, if odd we will get median by Line-106.

![alt text](img/Picture11.png?raw=true "function findMedian")
