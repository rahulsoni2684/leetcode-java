package daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CourseSchedule3 {

	public int scheduleCourse(int[][] courses) {

		// first sort the courses based on lastDay,
		// if lastDays are equal of two courses then sort based on duration.
		Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		// The Collections.reverseOrder() provides a Comparator that would sort the
		// elements in the PriorityQueue in a the opposite order to their natural order
		// in this case.
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

		int time = 0;

		for (int[] course : courses) {
			// check if duration <= lastDay then only we can consider this course
			if (course[0] <= course[1]) {
				// check if we select this course then this course can be completed with the
				// lastDay given
				if (course[0] + time <= course[1]) {
					// add this course into queue
					pQueue.offer(course[0]);
					// add the time of the current course
					time += course[0];
				}
				// check if we can swap this course by anyone added into queue
				else {
					// check into queue if any course having more duration then current course
					// duration
					if (pQueue.peek() > course[0]) {
						// remove this course from queue and subtract its duration from time
						time = time - pQueue.poll();
						// add the time of the current course
						time += course[0];
						// add this course into queue
						pQueue.offer(course[0]);
					}
				}
			}
		}
		// return the total no. of courses can be selected
		return pQueue.size();
	}
	public static void main(String[] args) {
		int courses[][] = {{100,200}, {200,1300}, {1000,1250}, {2000,3200}};
		CourseSchedule3 courseSchedule3 =  new CourseSchedule3();
		System.out.println(courseSchedule3.scheduleCourse(courses));
	}
}
