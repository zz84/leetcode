class Solution {
     public int divide(int dividend, int divisor){  
            if(divisor == 0){  
                return -1;  
            }  
            
            if (divisor == 1) return dividend;
            if (divisor == -1) {
                if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
                else return -dividend;
            }
            //符号位  
            int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;  

            // 求绝对值，为防止溢出使用long  
            long dvd = Math.abs((long) dividend);  
            long dvs = Math.abs((long) divisor);  

            int result = 0;  

            //主要程序代码  
            while(dvs <= dvd){  
                long tmp = dvs;  
                long mul = 1;  

                while(dvd >= (tmp << 1)){  
                    tmp <<= 1;  
                    mul <<= 1;  
                }  

                //减去最接近dvd的dvs的指数倍数的值（值为tmp）  
                dvd -= tmp;  

                result += mul;  

            }     
            return result*sign;  
        }  
}
