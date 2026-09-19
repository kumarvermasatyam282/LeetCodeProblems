class Solution {

    public long distance(int ux, int uy, int vx, int vy) {
        long dx = ux - vx;
        long dy = uy - vy;
        return dx * dx + dy * dy;
    }

    public boolean checkOverlap(int radius, int x, int y,
                                int x1, int y1, int x2, int y2) {

        int closestX = Math.max(x1, Math.min(x, x2));
        int closestY = Math.max(y1, Math.min(y, y2));

        return distance(x, y, closestX, closestY)
                <= (long) radius * radius;
    }
}