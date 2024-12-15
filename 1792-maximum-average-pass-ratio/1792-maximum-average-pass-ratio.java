class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Initialize the heap with initial gains and calculate initial average pass ratio
        for (int[] cls : classes) {
            double passi = cls[0];
            double totali = cls[1];
            double gain = gain(passi, totali);
            pq.offer(new double[] { gain, passi, totali });
        }
        
        // Distribute extraStudents
        while (extraStudents > 0) {
            double[] top = pq.poll();
            double passi = top[1];
            double totali = top[2];
            
            // Update the class with one more passing student
            passi++;
            totali++;
            
            // Update the new gain
            double newGain = gain(passi, totali);
            
            // Push back into the heap
            pq.offer(new double[] { newGain, passi, totali });
            
            // Decrease extraStudents count
            extraStudents--;
        }
        
        // Calculate the average pass ratio
        double sumRatio = 0.0;
        int numClasses = classes.length;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            double passi = top[1];
            double totali = top[2];
            sumRatio += passi / totali;
        }
        
        return sumRatio / numClasses;
    }
    
    private double gain(double passi, double totali) {
        return (passi + 1) / (totali + 1) - passi / totali;
    }
}