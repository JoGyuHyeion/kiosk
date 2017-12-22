package org.kiosk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.JsonStaffDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonStaffServiceImpl implements JsonStaffService {

	@Inject
	private JsonStaffDAO dao;
	@Inject
	private JsonTeamsService jsonTeamsService;
	@Inject
	private JsonMateService jsonMateService;
	@Inject
	private Vol_checkService volService;
	@Inject
	private Com_sectionService sectionService;

	private static final String VERSION = "session";

	@Override
	public void regist(JsonStaffDTO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public JsonStaffDTO read(String section_cd) throws Exception {
		return dao.read(section_cd);
	}

	@Override
	public void modify(JsonStaffDTO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(String section_cd) throws Exception {
		dao.delete(section_cd);
		volService.update(VERSION);
	}

	@Override
	public List<JsonStaffDTO> listAll(String section_fullcode) throws Exception {
		return dao.listAll(section_fullcode);
	}

	@Override
	public JsonStaffDTO getJsonStaff(String section_cd) throws Exception {
		int mapIndex = 0;
		JsonStaffDTO jsonStaffDTO = null;
		try {
			jsonStaffDTO = read(section_cd);
			List<TeamsDTO> teamList = jsonTeamsService.list(section_cd);

			for (int index = 0; index < teamList.size(); index++) {
				List<MateDTO> mateList = jsonMateService.list(teamList.get(index));
				Map<Integer, MateDTO> mateMap = new HashMap<Integer, MateDTO>();
				mapIndex = 0;
				for (MateDTO mateDTO : mateList) {
					mateMap.put(mapIndex, mateDTO);
					mapIndex++;
				}
				teamList.get(index).setMate(mateMap);
			}
			jsonStaffDTO.setTeams(teamList);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStaffDTO;
	}

	public Map<String, JsonStaffDTO> getAllJsonStaff() {
		Map<String, JsonStaffDTO> staffList = null;
		try {
			staffList = new HashMap<String, JsonStaffDTO>();
			
			for (Com_sectionVO vo : sectionService.listAll()) {

				staffList.put(vo.getSection_fullcode(), this.getJsonStaff(vo.getSection_fullcode()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}

}