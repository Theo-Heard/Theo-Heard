grid = [[0,9,7,0,0,0,4,0,0],
        [0,0,0,0,0,0,0,5,0],
        [5,4,6,0,0,1,7,0,0],
        [0,0,9,0,0,0,0,0,5],
        [2,0,0,0,9,8,0,0,7],
        [0,3,0,0,0,0,1,0,0],
        [6,0,0,0,4,0,0,1,0],
        [0,0,8,5,3,0,0,2,0],
        [0,0,0,6,0,0,0,0,0]]

def solve(board, row, col):

    if col == 9:
        if row == 8:
            return True
        row += 1
        col = 0

    if board[row][col] > 0:
        return solve(board, row, col + 1)
    
    for num in range(1,10):
        if valid(board, row, col, num):
            board[row][col] = num

            if solve(board, row, col + 1):
                return True
        
        grid[row][col] = 0
    
    return False
    

def valid(board, row, col, num):
    
    #check row
    for i in range(9):
        if board[row][i] == num:
            return False
    
    #check col
    for i in range(9):
        if board[i][col] == num:
            return False
    
    # check boxes
    box_x = row - row % 3
    box_y = col - col % 3

    for i in range(3):
        for j in range(3):
            if board[box_x + i][box_y + j] == num:
                return False
    
    return True

def print_grid(board):
    for i in range(len(board)):
        if i % 3 == 0 and i != 0:
            print('-----------------------')
        
        for j in range(len(board[0])):
            if j %3 == 0 and j != 0:
                print(' | ', end='')
            if j == 8:
                print(board[i][j])
            else:
                print(str(board[i][j]) + ' ', end='')

'''def find_empty(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                return (i, j) # row, col
    return None'''
print_grid(grid)
print('- - - - - - - - - - -')
if solve(grid, 0, 0):
    print_grid(grid)
else:
    print('no solution')
