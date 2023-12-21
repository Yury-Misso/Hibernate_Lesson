package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IFlightsService;
import jakarta.servlet.http.HttpServletRequest;

public class PageParamFactory {



    public PageParam getPageParam(HttpServletRequest req, IFlightsService service) {
        PageParam pageParam = new PageParam();

        int sizePage = Integer.parseInt(req.getParameter("pageSize"));
        pageParam.setSizePage(sizePage);

        String pageNoRaw = req.getParameter("pageNo");
        int maxPage = (int) Math.ceil((double) service.getCount() / sizePage);
        int pageNo = 0;

        try {
            pageNo = Integer.parseInt(pageNoRaw);
        } catch (NumberFormatException e) {
            String[] split = pageNoRaw.split("#");
            try {
                int pageNoOld = Integer.parseInt(split[1]);
                if (split[0].equalsIgnoreCase("prev")) {
                    pageNo = pageNoOld - 1;
                }
                if (split[0].equalsIgnoreCase("next")) {
                    pageNo = pageNoOld + 1;
                }
                if (pageNo < 1) {
                    pageNo = 1;
                } else if (pageNo > maxPage) {
                    pageNo = maxPage;
                }
            } catch (NumberFormatException ee) {
                throw new RuntimeException("Error parse pageNo", ee);
            }
        }

        pageParam.setPageNo(pageNo);
        pageParam.setMaxPage(maxPage);

        return pageParam;
    }

}
