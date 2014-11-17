package ctec.stateproject.model;

import android.app.Application;

public class AndroidState extends Application
{

	
	private String name, age, phrase, blather;
	
	public void onCreate()
	{
		name = "";
		age = "";
		phrase = "";
		blather = "";
		
	}
	public String getName()
	{
		return name;
	}

	public String getAge()
	{
		return age;
	}

	public String getPhrase()
	{
		return phrase;
	}

	public String getBlather()
	{
		return blather;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public void setPhrase(String phrase)
	{
		this.phrase = phrase;
	}

	public void setBlather(String blather)
	{
		this.blather = blather;
	}

}
