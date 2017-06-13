import os
class getPrimePath:
	def __init__(self):
		self.edges = {}
		self.allpath=[]

	def primepath(self,nodes, alledges):
	    l = len(nodes)
	    all_tours = []

	    #以每个节点为起点寻找到所有可达的路径
	    for i in range(l):
	        all_tours += self.find_alltour(nodes, alledges, i+1)
	    #去除那些有内部循环的路径    
	    all_tours = self.remove_internal_recycle(all_tours)
	    return self.remove_subprime(all_tours)

	def find_alltour(self,nodes, alledges, l):
	    if l == 1:
	        return nodes
	    
	    prev_tours = self.find_alltour(nodes, alledges, l-1)
	    tours = []

	    for tour in prev_tours:
	        #从之前路径的最后一个结点开始继续寻找
	        for next_node in alledges[tour[-1]]:
	        	if next_node!='-1':
	        	 	tours.append("".join([tour, next_node]))             
	    return tours
	def remove_internal_recycle(self,tours): #去除那些有内部循环的路径
	    simple_tours = []
	    for tour in tours:
	        l = len(tour)
	        okay = True

	        for i in range(l):
	            n = tour[i]
	            #如果路径中某个结点重复出现
	            if n in tour[i+1:]:
	                #如果没有内部循环则通过
	                if i==0 and n not in tour[i+1:-1]:
	                    pass
	                else:
	                    okay = False
	        if okay:
	            simple_tours.append(tour)

	    return simple_tours

	def remove_subprime(self,tours):  #去除子路径
	    #先对所得到的路径进行排序，从短到长排序
	    tours = sorted(tours, key = lambda tours:(len(tours),tours))

	    refined_tours = []
	    l = len(tours)

	    for i in range(l):
	        tour = tours[i]
	        redundant = False
	        #去除子路径，判断前面的路径是否出现在后面的路径中
	        for j in range(i+1, l):
	            if tour in tours[j]:
	                #如果出现将冗余标志置为True
	                redundant = True
	                break

	        if not redundant:
	            refined_tours.append(tour)

	    return refined_tours

	def getResult(self):
		i=0
		j=1
		f=open("cases/case6.txt","r")
		while True:
			current_edges=f.readlines()
			if current_edges:
				leng=int(current_edges[0])
				nodes=[str(i) for i in range(leng)]
				for node in nodes:
					self.edges[node]=current_edges[j].strip('[]\n').replace(',','').split(' ')
					j=j+1
			else:
				break
		f.close()
		pps = self.primepath(nodes, self.edges)
		for pp in pps:
			data=map(int,pp)
			self.allpath.append(list(data))
		return self.allpath

if __name__ == '__main__':
    pps=getPrimePath().getResult()
    print(len(pps))
    for pp in pps:
	    print(pp)
    

