#!/usr/bin/env python
# -*- coding: utf-8 -*-

import unittest
import sys
import pp_wxh

def readGraph(fileName):
    graph = []
    with open(fileName,'r') as f:
        f.readline()
        while 1:
            line = f.readline()
            if not line:
                break
            line = line.strip('[]\n')
            a = list(line.split(","))
            a = [int(x) for x in a]
            if a[0] == -1:
                a = []
            graph.append(a)
    graph = sorted(graph, key = lambda a:(len(a),a))
    return graph

class TestPrime(unittest.TestCase):

    def setUp(self):
        print("test case start")

    def test_primt(self):
        path = sys.path[0]
        pathName = path + 'anwser'+'/anwser6.txt'
        ans=readGraph(pathName)
        primePath = pp_wxh.getPrimePath()
        print(self.assertEqual(primePath.getResult(),ans))
        
    def tearDown(self):
        print("test case end")

if __name__ == "__main__":
    unittest.main()
