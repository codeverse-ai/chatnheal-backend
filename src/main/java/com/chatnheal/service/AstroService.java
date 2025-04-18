package com.chatnheal.service;

import com.chatnheal.dto.AstroMatchCompanion;
import com.chatnheal.dto.AstroResponse;
import com.chatnheal.util.ZodiacUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstroService {

    public AstroResponse generateProfile(String userId, String dob) {
        String zodiac = ZodiacUtil.getZodiacSign(dob);

        // Static or DB-fetched match logic (for MVP, keep hardcoded)
        List<AstroMatchCompanion> matches = switch (zodiac) {
            case "Leo" -> List.of(
                    new AstroMatchCompanion("Mystic Cancer", "Calm and nurturing", "url1", "Soothes your fire."),
                    new AstroMatchCompanion("Sagittarius Spark", "Adventurous", "url2", "Expands your dreams.")
            );
            case "Pisces" -> List.of(
                    new AstroMatchCompanion("Virgo Mentor", "Grounded wisdom", "url3", "Keeps you real."),
                    new AstroMatchCompanion("Taurus Touch", "Gentle & sensual", "url4", "Heals with presence.")
            );
            default -> List.of(
                    new AstroMatchCompanion("Lunar Guide", "Emotionally intelligent", "url5", "Understands your rhythm.")
            );
        };

        AstroResponse response = new AstroResponse();
        response.setZodiacSign(zodiac);
        response.setCompanions(matches);
        return response;
    }
}

