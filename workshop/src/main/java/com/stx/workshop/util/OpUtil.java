package com.stx.workshop.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class OpUtil {
	
	private static final int SCALE = 18;
	
	public static final BigDecimal PI = new BigDecimal("3.1415926535897932384626433832795");

	public static BigDecimal PI_DIV_180 = PI.divide(BigDecimal.valueOf(180), 32, RoundingMode.HALF_UP);
	public static BigDecimal PI_DIV_200 = PI.divide(BigDecimal.valueOf(200), 32, RoundingMode.HALF_UP);
	public static BigDecimal EPS = BigDecimal.ONE.scaleByPowerOfTen(-100);

	/**
	 * Addition Operation
	 * 
	 * @param src
	 * @param args
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal add(BigDecimal src, BigDecimal ...args) {
		if (null != args && args.length <= 0) {
			return src;
		}

		BigDecimal addFdr = BigDecimal.ZERO;
		for (BigDecimal x : args) {
			if (null == x) {
				continue;
			}
			
			addFdr = addFdr.add(x);
		}
		
		// If src have value then combine with add fodder
		if (null != src) {
			return src.add(addFdr);
		}

		// If src don't have value then return add fodder
		return addFdr;
	}
	
	/**
	 * Subtraction Operator
	 * 
	 * @param src
	 * @param args
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal sub(BigDecimal src, BigDecimal ...args) {
		if (null != args && args.length <= 0) {
			return src;
		}

		BigDecimal subFdr = BigDecimal.ZERO;
		for (BigDecimal x : args) {
			if (null == x || BigDecimal.ZERO.compareTo(x) == 0) {
				continue;
			}
			
			subFdr = subFdr.subtract(x);
		}
		
		if (null != src) {
			return src.subtract(subFdr);
		}

		return subFdr;
	}
	
	/**
	 * Multiplication Operator
	 * 
	 * @param src
	 * @param args
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal mul(BigDecimal src, BigDecimal ...args) {
		if (null == src || BigDecimal.ZERO.compareTo(src) == 0) {
			return BigDecimal.ZERO;
		}

		if (null != args && args.length <= 0) {
			throw new IllegalArgumentException("Arguments is required");
		}

		for (BigDecimal x : args) {
			if (null == x) {
				continue;
			}

			if (BigDecimal.ZERO.compareTo(x) == 0) {
				return BigDecimal.ZERO;
			}
			
			src = src.multiply(x);
		}

		return src;
	}
	
	/**
	 * Division Operator - Divide by Single Argument
	 * 
	 * @param src
	 * @param arg
	 * @param scale
	 * @param rodMde
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal div(BigDecimal src, BigDecimal arg, Integer scale, RoundingMode rodMde) {
		// Zero is not applicable on division
		if (null == src || null == arg 
				|| BigDecimal.ZERO.compareTo(src) == 0 
				|| BigDecimal.ZERO.compareTo(arg) == 0) {
			return BigDecimal.ZERO;
		}
		
		if (null != rodMde && null != scale) {
			return src.divide(arg, scale, rodMde);
		}
		
		if (null != rodMde) {
			return src.divide(arg, rodMde);
		}
		

		return src.divide(arg);
	}
	
	/**
	 * Division Operator - Divide by Multiple Arguments
	 * 
	 * @param src
	 * @param args
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal div(BigDecimal src, BigDecimal ...args) {
		if (null == src || BigDecimal.ZERO.compareTo(src) == 0) {
			return BigDecimal.ZERO;
		}

		if (null != args && args.length <= 0) {
			throw new IllegalArgumentException("Arguments is required");
		}
		
		for (BigDecimal x : args) {
			// Zero is not applicable on division
			if (null == x) {
				continue;
			}
			
			if (BigDecimal.ZERO.compareTo(x) == 0) {
				throw new IllegalArgumentException("Zero is not applicable on Division");
			}
			
			src = src.divide(x);
		}

		return src;
	}
	
	/**
	 * Division Operator - Divide by Multiple Arguments and Rounding Mode
	 * 
	 * @param src
	 * @param rodMde
	 * @param args
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal div(BigDecimal src, RoundingMode rodMde, BigDecimal ...args) {
		if (null == src || BigDecimal.ZERO.compareTo(src) == 0) {
			return BigDecimal.ZERO;
		}

		if (null != args && args.length <= 0) {
			throw new IllegalArgumentException("Arguments is required");
		}

		for (BigDecimal x : args) {
			// Zero is not applicable on division
			if (null == x) {
				continue;
			}
			
			if (BigDecimal.ZERO.compareTo(x) == 0) {
				throw new IllegalArgumentException("Zero is not applicable on Division");
			}
			
			src = src.divide(x, rodMde);
		}

		return src;
	}
	
	/**
	 * Division Operator - Divide by Multiple Arguments with Scale and Rounding Mode
	 * 
	 * @param src
	 * @param scale
	 * @param rodMde
	 * @param args
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal div(BigDecimal src, int scale, RoundingMode rodMde, BigDecimal ...args) {
		if (null == src || BigDecimal.ZERO.compareTo(src) == 0) {
			return BigDecimal.ZERO;
		}

		if (null != args && args.length <= 0) {
			throw new IllegalArgumentException("Arguments is required");
		}

		for (BigDecimal x : args) {
			// Zero is not applicable on division
			if (null == x) {
				continue;
			}
			
			if (BigDecimal.ZERO.compareTo(x) == 0) {
				throw new IllegalArgumentException("Zero is not applicable on Division");
			}
			
			src = src.divide(x, scale, rodMde);
		}

		return src;
	}
	
	/**
	 * Rounding Method
	 * 
	 * @param src
	 * @param scale
	 * @param rodMde
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal round(BigDecimal src, Integer scale, RoundingMode rodMde) {
		if (null == src || BigDecimal.ZERO.compareTo(src) == 0) {
			return BigDecimal.ZERO;
		}
		
		if (null == scale || null == rodMde) {
			throw new IllegalArgumentException("Scale and Rounding Mode is required");
		}
		
		return src.round(new MathContext(scale, rodMde));
	}
	
	/**
     * Compute the square root of x to a given scale, x >= 0.
     * 
     * @param x the value of x
     * @return the result value
     */
	public static BigDecimal sqrt(BigDecimal x) {
        // Check that x >= 0.
        if (x.signum() < 0) {
            throw new ArithmeticException("x < 0");
        }

        // n = x * (10 ^ (2 * SCALE))
        BigInteger n = x.movePointRight(SCALE << 1).toBigInteger();

        // The first approximation is the upper half of n.
        int bits = (n.bitLength() + 1) >> 1;
        BigInteger ix = n.shiftRight(bits);
        BigInteger ixPrev;

        // Loop until the approximations converge
        // (two successive approximations are equal after rounding).
        do {
            ixPrev = ix;

            // x = (x + n / x) / 2
            ix = ix.add(n.divide(ix)).shiftRight(1);

            Thread.yield();
        } while (ix.compareTo(ixPrev) != 0);

        return new BigDecimal(ix, SCALE);
    }
	
	/**
     * Compute the log10 of b to a given scale, x >= 0.
     * 
     * @param b the value of b
     * @return the result value
     */
	public static BigDecimal log10(BigDecimal b) {
        final int NUM_OF_DIGITS = SCALE + 2;
            // need to add one to get the right number of dp
            //  and then add one again to get the next number
            //  so I can round it correctly.
    
        MathContext mc = new MathContext(NUM_OF_DIGITS, RoundingMode.HALF_EVEN);
        //special conditions:
        // log(-x) -> exception
        // log(1) == 0 exactly;
        // log of a number lessthan one = -log(1/x)
        if(b.signum() <= 0) {
                throw new ArithmeticException("log of a negative number! (or zero)");
            }
        else if(b.compareTo(BigDecimal.ONE) == 0) {
                return BigDecimal.ZERO;
            } else if(b.compareTo(BigDecimal.ONE) < 0) {
                return (log10((BigDecimal.ONE).divide(b,mc))).negate();
            }
    
        StringBuilder sb = new StringBuilder();
        //number of digits on the left of the decimal point
        int leftDigits = b.precision() - b.scale();
    
        //so, the first digits of the log10 are:
        sb.append(leftDigits - 1).append(".");
    
        //this is the algorithm outlined in the webpage
        int n = 0;
        while (n < NUM_OF_DIGITS) {
            b = (b.movePointLeft(leftDigits - 1)).pow(10, mc);
            leftDigits = b.precision() - b.scale();
            sb.append(leftDigits - 1);
            n++;
        }
    
        BigDecimal ans = new BigDecimal(sb.toString());
    
        //Round the number to the correct number of decimal places.
        ans = ans.round(new MathContext(ans.precision() - ans.scale() + SCALE, RoundingMode.HALF_EVEN));
        return ans;
    }
	
	/**
     * Compute the integral root of x to a given scale, x >= 0.
     * 
     * @param x the value of x
     * @param index the integral root value
     * @param scale the desired scale of the result
     * @return the result value
     */
    public static BigDecimal intRoot(BigDecimal x, long index,
                                     int scale)
    {
        // Check that x >= 0.
        if (x.signum() < 0) {
            throw new IllegalArgumentException("x < 0");
        }

        int        sp1 = scale + 1;
        BigDecimal n   = x;
        BigDecimal i   = BigDecimal.valueOf(index);
        BigDecimal im1 = BigDecimal.valueOf(index-1);
        BigDecimal tolerance = BigDecimal.valueOf(5)
                                            .movePointLeft(sp1);
        BigDecimal xPrev;

        // The initial approximation is x / index.
        x = x.divide(i, scale, RoundingMode.HALF_EVEN);

        // Loop until the approximations converge
        // (two successive approximations are equal after rounding).
        do {
            // x^(index-1)
            BigDecimal xToIm1 = intPow(x, index-1, sp1);

            // x^index
            BigDecimal xToI =
                    x.multiply(xToIm1)
                        .setScale(sp1, RoundingMode.HALF_EVEN);

            // n + (index-1)*(x^index)
            BigDecimal numerator =
                    n.add(im1.multiply(xToI))
                        .setScale(sp1, RoundingMode.HALF_EVEN);

            // (index*(x^(index-1))
            BigDecimal denominator =
                    i.multiply(xToIm1)
                        .setScale(sp1, RoundingMode.HALF_EVEN);

            // x = (n + (index-1)*(x^index)) / (index*(x^(index-1)))
            xPrev = x;
            x = numerator
                    .divide(denominator, sp1, RoundingMode.DOWN);

            Thread.yield();
        } while (x.subtract(xPrev).abs().compareTo(tolerance) > 0);

        return x;
    }
	
	/**
     * Compute the natural logarithm of x to a given scale, x > 0.
     * 
     * @param x the value
     * @param scale the scale
     * @return the result
     */
    public static BigDecimal ln(BigDecimal x, int scale) {
        // Check that x > 0.
        if (x.signum() <= 0) {
            throw new IllegalArgumentException("x <= 0");
        }

        // The number of digits to the left of the decimal point.
        int magnitude = x.toString().length() - x.scale() - 1;

        if (magnitude < 3) {
            return lnNewton(x, scale);
        }

        // Compute magnitude * ln(x ^ (1 / magnitude)).
        else {

            // x^(1/magnitude)
            BigDecimal root = intRoot(x, magnitude, scale);

            // ln(x^(1/magnitude))
            BigDecimal lnRoot = lnNewton(root, scale);

            // magnitude*ln(x^(1/magnitude))
            return BigDecimal.valueOf(magnitude).multiply(lnRoot)
                        .setScale(scale, RoundingMode.HALF_EVEN);
        }
    }

     /**
     * Compute the natural logarithm of x to a given scale, x > 0.
     */
    private static BigDecimal lnNewton(BigDecimal x, int scale)
    {
        int        sp1 = scale + 1;
        BigDecimal n   = x;
        BigDecimal term;

        // Convergence tolerance = 5*(10^-(scale+1))
        BigDecimal tolerance = BigDecimal.valueOf(5)
                                            .movePointLeft(sp1);

        // Loop until the approximations converge
        // (two successive approximations are within the tolerance).
        do {

            // e^x
            BigDecimal eToX = exp(x, sp1);

            // (e^x - n)/e^x
            term = eToX.subtract(n)
                        .divide(eToX, sp1, RoundingMode.DOWN);

            // x - (e^x - n)/e^x
            x = x.subtract(term);

            Thread.yield();
        } while (term.compareTo(tolerance) > 0);

        return x.setScale(scale, RoundingMode.HALF_EVEN);
    }
    
    /**
     * Compute x ^ exponent to a given scale.
     * 
     * @param x the value x
     * @param exponent the exponent value
     * @param scale the desired scale of the result
     * @return the result value
     */
    public static BigDecimal intPow(BigDecimal x, long exponent,
                                      int scale) {
        // If the exponent is negative, compute 1 / (x ^ -exponent).
        if (exponent < 0) {
            return BigDecimal.valueOf(1)
                        .divide(intPow(x, -exponent, scale), scale,
                                RoundingMode.HALF_EVEN);
        }

        BigDecimal power = BigDecimal.valueOf(1);

        // Loop to compute value^exponent.
        while (exponent > 0) {

            // Is the rightmost bit a 1?
            if ((exponent & 1) == 1) {
                power = power.multiply(x)
                          .setScale(scale, RoundingMode.HALF_EVEN);
            }

            // Square x and shift exponent 1 bit to the right.
            x = x.multiply(x)
                    .setScale(scale, RoundingMode.HALF_EVEN);
            exponent >>= 1;

            Thread.yield();
        }

        return power;
    }
    
    /**
     * Compute e^x to a given scale.
     * Break x into its whole and fraction parts and
     * compute (e^(1 + fraction/whole))^whole using Taylor's formula.
     * @param x the value of x
     * @param scale the desired scale of the result
     * @return the result value
     */
    public static BigDecimal exp(BigDecimal x, int scale) {
        // e ^ 0 = 1
        if (x.signum() == 0) {
            return BigDecimal.valueOf(1);
        }

        // If x is negative, return 1/(e^-x).
        else if (x.signum() == -1) {
            return BigDecimal.valueOf(1)
                        .divide(exp(x.negate(), scale), scale,
                        		RoundingMode.HALF_EVEN);
        }

        // Compute the whole part of x.
        BigDecimal xWhole = x.setScale(0, RoundingMode.DOWN);

        // If there isn't a whole part, compute and return e^x.
        if (xWhole.signum() == 0) {
            return expTaylor(x, scale);
        }

        // Compute the fraction part of x.
        BigDecimal xFraction = x.subtract(xWhole);

        // z = 1 + fraction/whole
        BigDecimal z = BigDecimal.valueOf(1)
                            .add(xFraction.divide(
                                    xWhole, scale,
                                    RoundingMode.HALF_EVEN));

        // t = e^z
        BigDecimal t = expTaylor(z, scale);

        BigDecimal maxLong = BigDecimal.valueOf(Long.MAX_VALUE);
        BigDecimal result  = BigDecimal.valueOf(1);

        // Compute and return t^whole using intPower().
        // If whole > Long.MAX_VALUE, then first compute products
        // of e^Long.MAX_VALUE.
        while (xWhole.compareTo(maxLong) >= 0) {
            result = result.multiply(
                                intPow(t, Long.MAX_VALUE, scale))
                        .setScale(scale, RoundingMode.HALF_EVEN);
            xWhole = xWhole.subtract(maxLong);

            Thread.yield();
        }
        return result.multiply(intPow(t, xWhole.longValue(), scale))
                        .setScale(scale, RoundingMode.HALF_EVEN);
    }

    /**
     * Compute e ^ x to a given scale by the Taylor series.
     * @param x the value of x
     * @param scale the desired scale of the result
     * @return the result value
     */
    private static BigDecimal expTaylor(BigDecimal x, int scale)
    {
        BigDecimal factorial = BigDecimal.valueOf(1);
        BigDecimal xPower    = x;
        BigDecimal sumPrev;

        // 1 + x
        BigDecimal sum  = x.add(BigDecimal.valueOf(1));

        // Loop until the sums converge
        // (two successive sums are equal after rounding).
        int i = 2;
        do {
            // x^i
            xPower = xPower.multiply(x)
                        .setScale(scale, RoundingMode.HALF_EVEN);

            // i!
            factorial = factorial.multiply(BigDecimal.valueOf(i));

            // x ^ i / i!
            BigDecimal term = xPower
                                .divide(factorial, scale,
                                		RoundingMode.HALF_EVEN);

            // sum = sum + x ^ i / i!
            sumPrev = sum;
            sum = sum.add(term);

            ++i;
            Thread.yield();
        } while (sum.compareTo(sumPrev) != 0);

        return sum;
    }
    
    public static BigDecimal asin(BigDecimal src) {
        return BigDecimal.valueOf(Math.asin(src.doubleValue()));
    }

    public static BigDecimal acos(BigDecimal src) {
        return BigDecimal.valueOf(Math.acos(src.doubleValue()));
    }

    public static BigDecimal atan(BigDecimal src) {
        return BigDecimal.valueOf(Math.atan(src.doubleValue()));
    }
}
