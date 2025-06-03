package co.com.sisapco.util;

import java.text.ParseException;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Copropiedad;


public class ConvertCopropiedad {
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
    public CopropiedadDTO copropiedadvertToDTO(Copropiedad copropiedad) throws ParseException {
        return modelMapper.map(copropiedad, CopropiedadDTO.class);
    }
    
    public Iterable<CopropiedadDTO> listCopropiedadvertToDTO(Iterable<Copropiedad> copropiedad) throws ParseException {
    	 return Arrays.asList(modelMapper.map(copropiedad, CopropiedadDTO[].class));
    }

}
