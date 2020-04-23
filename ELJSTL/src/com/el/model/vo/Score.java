package com.el.model.vo;

public class Score {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;

	// 평균
	private double avg;

	// 등급
	private String grade;

	// 평균점수 : A
	// 90 점 초과 : A
	// 80~90 점 : B
	// 70~80 점 : C
	// 60~70 점 : D
	// 이하 : F

	public Score() {
		super();
	}

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = getSum(kor, eng, math);
		this.avg = getAvg(sum);
		this.grade = getGrade(avg);
	}

	public double getAvg(int sum) {
		avg = sum / 3;
		return avg;
	}

	public int getSum(int kor, int eng, int math) {
		sum = kor + eng + math;
		return sum;
	}

	public String getGrade(double avg) {
		if (avg > 90) {
			grade = "A";
		} else if (avg > 80) {
			grade = "B";
		} else if (avg > 70) {
			grade = "C";
		} else if (avg > 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		return grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
				+ avg + ", grade=" + grade + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eng;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (eng != other.eng)
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}

}
