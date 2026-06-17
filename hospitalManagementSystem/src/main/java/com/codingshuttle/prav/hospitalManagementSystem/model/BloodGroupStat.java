package com.codingshuttle.prav.hospitalManagementSystem.model;

import com.codingshuttle.prav.hospitalManagementSystem.enums.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStat {


	private final BloodGroupType bloodGroup;
	private final Long count;

}
