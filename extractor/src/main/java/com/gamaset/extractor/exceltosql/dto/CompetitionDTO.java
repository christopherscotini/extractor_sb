package com.gamaset.extractor.exceltosql.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CompetitionDTO {
	
	public static final int ID_COLUMN = 0;
	public static final int NAME_COLUMN = 1;
	public static final int URL_COLUMN = 2;
	public static final int FLAG_ID_COLUMN = 3;
	public static final int COUNTRY_ID_COLUMN = 4;
	
	private Long id;
	private String name;
	private String link;
	private FlagDTO flag;
	private CountryDTO country;
	
	public CompetitionDTO() {	}
	
	public CompetitionDTO(Long id, String name, String link, FlagDTO flag, CountryDTO country) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.flag = flag;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FlagDTO getFlag() {
		return flag;
	}

	public void setFlag(FlagDTO flag) {
		this.flag = flag;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
