This time your goal is to
predict the sigma points.

So we start from a point where we
already have the augmented sigma points.

Let's quickly repeat the meaning
of each of these points.

This column is one sigma point.

We have here a value for the position x.

For the position y, for
the velocity v, for

the yaw angle psi, and
for the yaw rate psi dot.

This value is the longitudinal
acceleration noise mu a.

And this value is the yaw
acceleration noise mu psi dot dot.

The noise values are mostly 0.

But not for all sigma points,
as you can see here.

Make sure to also put these two noise
values correctly into the process model.

This is the matrix you want to fill
with with the predicted sigma points.

And, of course, you need delta_t
if you want to calculate numbers.

The main thing you have to do here is
implement the CTR remodel into C++ code.

Make sure to also consider
the effect of the process modes, and

to catch division by zero.

All right, good luck.