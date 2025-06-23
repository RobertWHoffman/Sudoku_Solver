ffrom itertools import permutations

def generateTemplates(size):
    templates = []
    length = size[0]*size[1]
    blank_templates = ["1"] * length
    for pos1 in range(length):
        for pos2 in range(length):
            if pos1 < pos2:
                blank_templates[pos2] = '0' +  blank_templates[pos2]
            elif pos1 > pos2:
                blank_templates[pos2] = blank_templates[pos2] + '0'
    template_map = {}
    for row in range(length):
        template_map[blank_templates[row]] = row//size[0]
    #print(template_map)

    for pos_templates in permutations(blank_templates):
        tracker = [False] * len(pos_templates)
        fin = True
        for pos in range(len(pos_templates)):
            if (pos % size[0]) < size[0]-1:
                if template_map[pos_templates[pos]] == template_map[pos_templates[pos+1]]:
                    fin = False
                    break
        if fin:
            temp_temp = ""
            for temp in pos_templates:
                temp_temp += temp
            #print(pos_templates)
            #print(temp_temp)
            templates.append(temp_temp)
    return templates
            
def solve(size,init,logger):
    templates = generateTemplates(size)
    
    template_tracker = {}
    zero_tracker = []
    board_subsize = size[0]*size[1]
    board_size = board_subsize*board_subsize
    
    for val in range(board_subsize):
        template_tracker[val+1] = []
    
    if logger:
        print(template_tracker)
    
    
    for position in range(board_size):
        value = init[position]
        if value != 0: # populating template tracker
            if logger:
                print('')
                print("making changes: ")
            for curr_value in range(board_subsize): # cycle through all values
                if curr_value+1 == value:
                    if len(template_tracker[curr_value+1]) == 0: 
                        # If the number in the current position is the same as the current value 
                        # and the tracker for that value is empty, add all templates that do have a 1 at that position
                        if logger:
                            print("adding templates from " +str(curr_value+1)+ " where position: " + str(position//9) +","+ str(position%9)+" is " + str(value) )
                        for tmp in templates:
                            if tmp[position] == "1":
                                template_tracker[curr_value+1].append(tmp)
                    else:
                        # If the number in the current position is the same as the current value 
                        # and the tracker for that value is not empty, remove all templates that do not have a 1 at that position
                        if logger:
                            print("removing templates from " +str(curr_value+1)+ " where position: " + str(position//9) +","+ str(position%9)+" is not " + str(value) )
                        template_storage = []
                        for template in template_tracker[curr_value+1]:
                            if template[position] == "1":
                                template_storage.append(template)
                        template_tracker[curr_value+1] = template_storage
                else:
                    if len(template_tracker[curr_value+1]) == 0:
                        # If the number in the current position is not the same as the current value 
                        # and the tracker for that value is empty, add all templates that do not have a 1 at that position
                        if logger:
                            print("adding templates from " +str(curr_value+1)+ " where position: " + str(position//9) +","+ str(position%9)+" is not " + str(value) )
                        for tmp in templates:
                            if tmp[position] != "1":
                                template_tracker[curr_value+1].append(tmp)
                    else:
                        # If the number in the current position is not the same as the current value 
                        # and the tracker for that value is not empty, remove all templates that do have a 1 at that position
                        if logger:    
                            print("removing templates from " +str(curr_value+1)+ " where position: " + str(position//9) +","+ str(position%9)+" is " + str(value) )
                        for template in template_tracker[curr_value+1]:
                            if template[position] == "1":
                                template_tracker[curr_value+1].remove(template)
        else:
            zero_tracker.append(position)
            
    # print(zero_tracker)
    # last prune before sudoku logic is needed    
    for value in range(board_subsize):
        if len(template_tracker[value+1]) == 1: # only 1 position configuration is possable remove all other templates that overlap
            #print(template_tracker[value+1])
            for curr_value in range(board_subsize):
                if value != curr_value:  
                    for template in template_tracker[curr_value+1]:
                        #print(template)
                        removed = False
                        for position in range(board_size):
                            if template[position] == "1" and not removed:
                                if template_tracker[value+1][0][position] == template[position]:
                                    #print(template_tracker[value+1][0])
                                    #print(template)
                                    if logger:
                                        print('')
                                        print("overlap at position: " + str(position) + ", removing infesable template")
                                        print('')
                                    template_tracker[curr_value+1].remove(template)
                                    removed = True
    #print(template_tracker)
    completion = {}
    for val in range(board_subsize):
        completion[val+1] = False
    
    finished = False
    siev_tracker = {}
    
    for value in range(board_subsize):
        if len(template_tracker[value+1]) > 1:
            reduction_tracker = {}
            for val in range(board_size):
                reduction_tracker[val] = 0
            for template in template_tracker[value+1]:
                for val in range(board_size):
                    if template[val] == "1":
                        if reduction_tracker[val]+1 == len(template_tracker[value+1]):
                            siev_tracker[val] = value+1
                            if logger:
                                print("adding " + str(value+1) + " at position " + str(val))
                        else:
                            reduction_tracker[val] += 1
        else:
            for pos in range(board_size):
                if template_tracker[value+1][0][pos] == "1":
                    siev_tracker[pos] = value+1
                    if logger:
                        print("adding " + str(value+1) + " at position " + str(pos))
            completion[value+1] = True
    while not finished:
        for value in completion:
            if not completion[value]:
                for temp in template_tracker[value]:
                    if len(template_tracker[value]) > 1:
                        for sieve in siev_tracker:
                            if temp[sieve] == "1" and siev_tracker[sieve] != value:
                                template_tracker[value].remove(temp)
                                break
                    else:
                        completion[value] = True
        for val in completion:
            if not completion[val]:
                break
            finished = True
    
    if logger:
        print('')
    #print(template_tracker)
    #print(init)
    validateAnswers(size,template_tracker, init)
    
def validateAnswers(size, template_tracker, init):
    if logger:
        print(template_tracker)
    row_check = {}
    colum_check = {}
    group_check = {}
    
    board_subsize = size[0]*size[1]
    board_size = board_subsize*board_subsize
    #print(board_subsize)
    for val in range(board_subsize):
        row_check[val] = []
        colum_check[val] = []
        group_check[val] = []
    
    for pos in range(board_size):
        row = pos//board_subsize
        col = pos%board_subsize
        group = pos//size[0]-((pos//board_subsize)*size[0]-(pos//(board_subsize*size[1]))*size[1])
        
        if init[pos] == 0:
            if logger:
                print(str(pos) + " is unknown")
            for value in range(board_subsize):
                if template_tracker[value+1][0][pos] == "1":
                    init[pos] = value+1
                    if logger:
                        print("Unknown value at position " + str(pos) + " is " + str(init[pos]))
        
        row_check[row].append(init[pos])
        colum_check[col].append(init[pos])
        group_check[group].append(init[pos])
        
    failed = False
    value_check = {}        
    
    for row in row_check:
        for val in range(board_subsize):
            value_check[val+1] = False
        if not failed:
            for value in row_check[row]:
                if not value_check[value]:
                    value_check[value] = True
                else:
                    failed = True
                    print("Inncorect: error in Row: " + str(row) + " Row has mor than one ", value)
                    break
        else:
            break
    for col in colum_check:
        for val in range(board_subsize):
            value_check[val+1] = False
        if not failed:
            for value in colum_check[row]:
                if not value_check[value]:
                    value_check[value] = True
                else:
                    failed = True
                    print("Inncorect: error in Col: " + str(col) + " Col has mor than one ", value)
                    break
        else:
            break
    for grp in group_check:
        for val in range(board_subsize):
            value_check[val+1] = False
        if not failed:
            for value in group_check[row]:
                if not value_check[value]:
                    value_check[value] = True
                else:
                    failed = True
                    print("Inncorect: error in Group: " + str(grp) + " Group has mor than one ", value)
                    break
        else:
            break
    if not failed:
        print(" Solved! ") 
        print(init)
    else: 
        print(init) 

def test():
    x_size = 3
    y_size = 3
    sudoku_size = [x_size,y_size]
    test_sudoku_init = [5, 7, 3, 8, 2, 1, 4, 0, 0,
                         8, 2, 6, 0, 9, 4, 1, 0, 0,
                         0, 1, 4, 0, 0, 3, 0, 5, 2,
                         3, 0, 8, 7, 5, 2, 0, 0, 4,
                         4, 9, 0, 1, 3, 0, 0, 2, 0,
                         2, 0, 1, 4, 8, 9, 0, 0, 6,
                         0, 3, 2, 0, 0, 7, 0, 8, 5,
                         7, 8, 9, 0, 6, 5, 2, 0, 0,
                         6, 4, 5, 2, 1, 8, 7, 0, 0]

    logger = True
    solve(sudoku_size, test_sudoku_init,logger)  
