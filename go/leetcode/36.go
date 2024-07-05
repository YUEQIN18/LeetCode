package leetcode

func isValidSudoku(board [][]byte) bool {
	rowMap := [9][9]bool{}       // [行索引][数字]
	colMap := [9][9]bool{}       // [列索引][数字]
	matrixMap := [3][3][9]bool{} // [行索引/3][列索引/3][数字]
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] == '.' {
				continue
			}
			index := board[i][j] - '1'
			if rowMap[i][index] || colMap[j][index] || matrixMap[i/3][j/3][index] {
				return false
			}
			rowMap[i][index] = true
			colMap[j][index] = true
			matrixMap[i/3][j/3][index] = true
		}
	}
	return true
}
