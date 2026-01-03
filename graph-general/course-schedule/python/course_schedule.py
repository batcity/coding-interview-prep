# https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150

from collections import defaultdict

class Solution:

    def build_adjacency_list(self, numCourses: int, prerequisites: List[List[int]]):

        prereqs_by_course = defaultdict(list)

        for pair in prerequisites:

            course = pair[0]
            prerequisite = pair[1]
            prereqs_by_course[course].append(prerequisite)

        return prereqs_by_course

    def does_circle_exist(self, key, values, seen, prereqs_by_course):

        print("seen right now is", seen)
        if values is None:
            return False

        if key in seen:
            print("I've seen this", key)
            return True

        seen.append(key)

        for value in values:
            if self.does_circle_exist(value, prereqs_by_course.get(value), seen, prereqs_by_course):
                return True

        return False



    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # alright my plan is to make an adjacency list that looks like this, prereqs by course
        # then dfs through each course, if there's a circle then you're out
        # print(self.build_adjacency_list(numCourses, prerequisites))

        prereqs_by_course = self.build_adjacency_list(numCourses, prerequisites)

        for key, values in prereqs_by_course.items():

            seen = []
            if self.does_circle_exist(key, values, seen, prereqs_by_course):
                return False

        return True