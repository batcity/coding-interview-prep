# https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150

# Time complexity: O(V + E), where V = numCourses and E = number of prerequisite pairs
# Space complexity: O(V + E) for the adjacency list, visited sets, and recursion stack
from collections import defaultdict

class Solution:

    def build_adjacency_list(self, numCourses: int, prerequisites: List[List[int]]):

        prereqs_by_course = defaultdict(list)

        for pair in prerequisites:

            course = pair[0]
            prerequisite = pair[1]
            prereqs_by_course[course].append(prerequisite)

        return prereqs_by_course

    def does_circle_exist(self, key, values, visiting, visited, prereqs_by_course):

        if key in visited:
            return False

        if values is None:
            return False

        if key in visiting:
            return True

        visiting.add(key)

        for value in values:
            if self.does_circle_exist(value, prereqs_by_course.get(value), visiting, visited, prereqs_by_course):
                return True

        visiting.remove(key)
        visited.add(key)

        return False



    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # alright my plan is to make an adjacency list that looks like this, prereqs by course
        # then dfs through each course, if there's a circle then you're out

        prereqs_by_course = self.build_adjacency_list(numCourses, prerequisites)
        visited = set()
        visiting = set()

        for key, values in prereqs_by_course.items():
            if self.does_circle_exist(key, values, visiting, visited, prereqs_by_course):
                return False

        return True