# https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150

class Solution:

    def build_adjacency_matrix(self, numCourses: int, prerequisites: List[List[int]]):

        output = [[False for _ in range(numCourses)] for _ in range(numCourses)]

        for pair in prerequisites:
            output[pair[1]][pair[0]] = True

        return output

    def path_exists()

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        print(self.build_adjacency_matrix(numCourses, prerequisites))

        # alright my confusion now is, how shuld the adjacency matrix have been built to navigate this next block
        # course to prereqs or prereqs to course?

        path_exists