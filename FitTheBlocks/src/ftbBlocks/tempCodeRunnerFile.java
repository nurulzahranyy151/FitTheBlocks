 private void drawBlock(Graphics g) {
        if (block == null) return; // Check if block is null
    
        int h = block.getHeight();
        int w = block.getWidth();
        Color c = block.getColor();
        int[][] shape = block.getShape();
    
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] == 1) {
                    int x = (block.getX() + col) * gridCellSize;
                    int y = (block.getY() + row) * gridCellSize;
    
                    drawGridSquare(g, c, x, y);
                }
            }
        }
    }